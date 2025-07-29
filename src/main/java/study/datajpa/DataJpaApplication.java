package study.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
public class DataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataJpaApplication.class, args);
    }

    // AuditorAware 인터페이스를 구현하고 스프링 빈으로 등록해야 Spring Data Auditing이 @CreatedBy나 @LastModifiedBy 필드에 현재 사용자 정보를 채울 수 있다
    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of(UUID.randomUUID().toString());
    }
}
