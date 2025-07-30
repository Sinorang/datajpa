package study.datajpa.repository;

public interface UsernameOnly {

    //    @Value("{target.username + ' ' + target.age}") // 오픈 projections
    String getUsername();
}
