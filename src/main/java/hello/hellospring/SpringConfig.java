package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    // JDBC방식
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

//    // JPA 방식
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em =em;
//    }
//    @Bean
//    public MemberService memberService(){
//    return new MemberService(memberRepository());
//}
//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();          // 메모리 주입방식
////        return new JdbcMemberRepository(dataSource);    // JDBC 방식
////        return new JdbcTemplateMemberRepository(dataSource);    // JDBC Template 방식
////        return new JpaMemberRepository(em);    // JPA(Java Persistence API)방식
//    }


    // Spring JPA 방식
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    // AOP
//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

}
