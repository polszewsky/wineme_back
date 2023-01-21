package polszewsky.wineme.app.user_wine;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import polszewsky.wineme.app.administration.users.User;
import polszewsky.wineme.app.common.db_utils.CreatedEditedAt;
import polszewsky.wineme.app.wine.Wine;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserWine.class)
public abstract class UserWine_ {

	public static volatile SingularAttribute<UserWine, CreatedEditedAt> createdEditedAt;
	public static volatile SingularAttribute<UserWine, Integer> score;
	public static volatile SingularAttribute<UserWine, Integer> year;
	public static volatile SingularAttribute<UserWine, String> review;
	public static volatile SingularAttribute<UserWine, Integer> hue;
	public static volatile SingularAttribute<UserWine, Integer> id;
	public static volatile SingularAttribute<UserWine, Integer> body;
	public static volatile SingularAttribute<UserWine, User> user;
	public static volatile SingularAttribute<UserWine, Wine> wine;

	public static final String CREATED_EDITED_AT = "createdEditedAt";
	public static final String SCORE = "score";
	public static final String YEAR = "year";
	public static final String REVIEW = "review";
	public static final String HUE = "hue";
	public static final String ID = "id";
	public static final String BODY = "body";
	public static final String USER = "user";
	public static final String WINE = "wine";

}

