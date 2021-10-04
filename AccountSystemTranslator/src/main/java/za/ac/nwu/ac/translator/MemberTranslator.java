package za.ac.nwu.ac.translator;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;

import java.util.List;

@Component
public interface MemberTranslator {
    List<MemberDto> getAllMembers();
}
