package polszewsky.wineme.app.administration.privlge;

import jakarta.persistence.metamodel.CollectionAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import polszewsky.wineme.app.administration.roles.Role;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Privilege.class)
public abstract class Privilege_ {

	public static volatile CollectionAttribute<Privilege, Role> roles;
	public static volatile SingularAttribute<Privilege, String> name;
	public static volatile SingularAttribute<Privilege, Long> id;

	public static final String ROLES = "roles";
	public static final String NAME = "name";
	public static final String ID = "id";

}

