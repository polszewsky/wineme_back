package polszewsky.wineme.app.common.db_utils;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CreatedEditedAt.class)
public abstract class CreatedEditedAt_ {

	public static volatile SingularAttribute<CreatedEditedAt, LocalDateTime> createdAt;
	public static volatile SingularAttribute<CreatedEditedAt, LocalDateTime> editedAt;

	public static final String CREATED_AT = "createdAt";
	public static final String EDITED_AT = "editedAt";

}

