package digital.innovation.one.apiCadastroUsuarios.utils;

import digital.innovation.one.apiCadastroUsuarios.dto.request.PhoneDTO;
import digital.innovation.one.apiCadastroUsuarios.entity.PhoneModel;
import digital.innovation.one.apiCadastroUsuarios.enums.PhoneType;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static PhoneModel createFakeEntity() {
        return PhoneModel.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
