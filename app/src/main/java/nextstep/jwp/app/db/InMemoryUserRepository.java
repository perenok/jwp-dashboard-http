package nextstep.jwp.app.db;


import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import nextstep.jwp.app.domain.User;

public class InMemoryUserRepository {

    private static final Map<String, User> database = new ConcurrentHashMap<>();
    private static Long id = 1L;

    static {
        final User user = new User(id++, "gugu", "password", "hkkang@woowahan.com");
        database.put(user.getAccount(), user);
    }

    public static void save(User user) {
        User saveUser = new User(id++, user.getAccount(), user.getPassword(), user.getEmail());
        database.put(user.getAccount(), saveUser);
    }

    public static Optional<User> findByAccount(String account) {
        return Optional.ofNullable(database.get(account));
    }
}
