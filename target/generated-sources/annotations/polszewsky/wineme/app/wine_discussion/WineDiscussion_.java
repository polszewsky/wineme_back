package polszewsky.wineme.app.wine_discussion;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import polszewsky.wineme.app.administration.users.User;
import polszewsky.wineme.app.common.db_utils.CreatedEditedAt;
import polszewsky.wineme.app.wine.Wine;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WineDiscussion.class)
public abstract class WineDiscussion_ {

	public static volatile SingularAttribute<WineDiscussion, CreatedEditedAt> createdEditedAt;
	public static volatile SingularAttribute<WineDiscussion, String> comment;
	public static volatile SingularAttribute<WineDiscussion, Integer> id;
	public static volatile SingularAttribute<WineDiscussion, User> user;
	public static volatile SingularAttribute<WineDiscussion, Wine> wine;

	public static final String CREATED_EDITED_AT = "createdEditedAt";
	public static final String COMMENT = "comment";
	public static final String ID = "id";
	public static final String USER = "user";
	public static final String WINE = "wine";

}

