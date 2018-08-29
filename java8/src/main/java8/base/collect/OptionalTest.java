package java8.base.collect;

import java8.VO.User;

import java.util.Optional;
public class OptionalTest {

   /* @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> empty = Optional.empty();
        empty.get();
    }*/

    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        User user = new User();
        Optional<User> empty = Optional.of(user);
    }
    //https://www.itcodemonkey.com/article/975.html 10/26
}
