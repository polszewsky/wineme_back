package polszewsky.wineme.app.wine;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import polszewsky.wineme.app.common.db_utils.CreatedEditedAt;
import polszewsky.wineme.app.wine_discussion.WineDiscussion;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Wine.class)
public abstract class Wine_ {

	public static volatile SingularAttribute<Wine, Double> alcohol;
	public static volatile SingularAttribute<Wine, Integer> acid;
	public static volatile SingularAttribute<Wine, CreatedEditedAt> createdEditedAt;
	public static volatile SingularAttribute<Wine, String> country;
	public static volatile SingularAttribute<Wine, String> name;
	public static volatile SingularAttribute<Wine, String> batch;
	public static volatile ListAttribute<Wine, WineDiscussion> discussions;
	public static volatile SingularAttribute<Wine, Integer> id;
	public static volatile SingularAttribute<Wine, String> type;
	public static volatile SingularAttribute<Wine, String> region;

	public static final String ALCOHOL = "alcohol";
	public static final String ACID = "acid";
	public static final String CREATED_EDITED_AT = "createdEditedAt";
	public static final String COUNTRY = "country";
	public static final String NAME = "name";
	public static final String BATCH = "batch";
	public static final String DISCUSSIONS = "discussions";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String REGION = "region";

}

