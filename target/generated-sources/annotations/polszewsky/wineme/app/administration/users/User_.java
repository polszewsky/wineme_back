package polszewsky.wineme.app.administration.users;

import jakarta.persistence.metamodel.CollectionAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import polszewsky.wineme.app.administration.roles.Role;
import polszewsky.wineme.app.common.enums.SubscriptionLevelEnum;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> password;
	public static volatile CollectionAttribute<User, Role> roles;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, SubscriptionLevelEnum> subscription;
	public static volatile SingularAttribute<User, String> email;

	public static final String FIRST_NAME = "firstName";
	public static final String PASSWORD = "password";
	public static final String ROLES = "roles";
	public static final String ID = "id";
	public static final String SUBSCRIPTION = "subscription";
	public static final String EMAIL = "email";

}

