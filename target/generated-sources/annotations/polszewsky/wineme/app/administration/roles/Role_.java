package polszewsky.wineme.app.administration.roles;

import jakarta.persistence.metamodel.CollectionAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import polszewsky.wineme.app.administration.privlge.Privilege;
import polszewsky.wineme.app.administration.users.User;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile CollectionAttribute<Role, Privilege> privileges;
	public static volatile SingularAttribute<Role, String> name;
	public static volatile SingularAttribute<Role, Long> id;
	public static volatile CollectionAttribute<Role, User> users;

	public static final String PRIVILEGES = "privileges";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String USERS = "users";

}

