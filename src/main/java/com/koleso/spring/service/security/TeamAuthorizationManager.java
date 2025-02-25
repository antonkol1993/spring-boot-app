package com.koleso.spring.service.security;

import com.koleso.spring.objects.Person;
import com.koleso.spring.dto.PersonDetailsDTO;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;
@Component
public class TeamAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext context) {
        Authentication auth = authentication.get();

        if (auth != null && auth.isAuthenticated()) {
            Object principal = auth.getPrincipal();

            if (principal instanceof PersonDetailsDTO personDetailsDTO) {
                Person person = personDetailsDTO.getPerson();

                // Проверяем, есть ли у пользователя роль "ADMIN"
                boolean isAdmin = auth.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

                // Проверяем, есть ли у пользователя роль "MANAGER"
                boolean isManager = auth.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_MANAGER"));

                if (isAdmin) {
                    return new AuthorizationDecision(true);  // Разрешаем доступ для ADMIN без проверок на команду
                }
                if (isManager && person.getTeam() != null) {
                    // Получаем ID команды из URL
                    String requestPath = context.getRequest().getRequestURI();
                    Long teamIdFromUrl = extractTeamIdFromPath(requestPath);

                    // Проверяем, совпадает ли ID команды пользователя с ID из URL
                    if (teamIdFromUrl != null && teamIdFromUrl.equals(person.getTeam().getId())) {
                        return new AuthorizationDecision(true); // Разрешаем доступ
                    }
                }
            }
        }
        return new AuthorizationDecision(false); // Запрещаем доступ
    }

    private Long extractTeamIdFromPath(String path) {
        String[] parts = path.split("/");
        try {
            return Long.parseLong(parts[parts.length - 1]); // ID в конце URL
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
