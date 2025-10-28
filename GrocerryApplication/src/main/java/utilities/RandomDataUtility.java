package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
Faker faker=new Faker();
public String randomUserName() {
	return faker.name().username();
}
public String randomPassword() {
	return faker.internet().password();
}
public String randomFullName() {
	return faker.name().firstName();
}
public String randomEmail() {
	return faker.internet().emailAddress();
}
}
