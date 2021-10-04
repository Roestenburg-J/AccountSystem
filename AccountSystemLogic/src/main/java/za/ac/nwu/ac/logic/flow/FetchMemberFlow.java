package za.ac.nwu.ac.logic.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;

import java.util.List;

@Component
public interface FetchMemberFlow {
    List<MemberDto> getAllMembers();
}
