package study.datajpa.repository;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import study.datajpa.entity.Member;
import study.datajpa.entity.Team;

public class MemberSpec {

    public static Specification<Member> teamName(final String teamName) {
        return (root, query, builder) -> {

            if (StringUtils.isEmpty(teamName)) {
                return null;
            }

            Join<Member, Team> t = root.join("team", JoinType.INNER); // 회원과 조인
            return builder.equal(t.get("name"), teamName);
        };
    }

    public static Specification<Member> username(final String username) {
        return (root, query, builder) ->
                builder.equal(root.get("username"), username);
    }
}
