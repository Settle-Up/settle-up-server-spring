package settleup.backend.domain.user.entity.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * BE 로직상 userId filed 는 userUUID , FE 에게 보내주기 위한 컨벤션
 */
public class LoginDto {
    private String accessToken;
    private String subject;
    private String issuedTime;
    private String expiresIn;
    private String userId;
    private String userName;
    private Boolean isDecimalInputOption;

}