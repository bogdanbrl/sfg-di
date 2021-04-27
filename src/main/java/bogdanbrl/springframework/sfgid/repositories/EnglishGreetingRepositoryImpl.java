package bogdanbrl.springframework.sfgid.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository{
    @Override
    public String getGreeting() {
        return "Hello World - EN";
    }
}
