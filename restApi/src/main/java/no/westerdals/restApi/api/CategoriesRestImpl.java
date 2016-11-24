package no.westerdals.restApi.api;

import no.westerdals.quiz.ejb.RootCategoryEJB;
import no.westerdals.restApi.dto.CategoryConverter;
import no.westerdals.restApi.dto.CategoryDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;

import static javax.rmi.CORBA.Util.wrapException;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class CategoriesRestImpl implements CategoriesRestApi {
    @EJB
    private RootCategoryEJB ejb;

    @Override
    public List<CategoryDto> get() {
        return CategoryConverter.transform(ejb.getAll());

    }

    @Override
    public Long createCategory(CategoryDto dto) {

        if (!(Strings.isNullOrEmpty(dto.newsId)
                && Strings.isNullOrEmpty(dto.id))) {
            throw new WebApplicationException("Cannot specify id for a newly generated category", 400);
        }
        if (dto.creationTime != null) {
            throw new WebApplicationException("Cannot specify creationTime for a newly generated news", 400);
        }

        Long id;
        try {
            id = ejb.createNews(dto.authorId, dto.text, dto.country);
        } catch (Exception e) {
            throw wrapException(e);
        }

        return id;
    }

    @Override
    public Long getCategory(Long id) {

    }
    @Override
    public List<CategoryDto> getCategoriesWithQuizzes() {
        return CategoryConverter.transform(ejb.getCategoriesWithQuizzes());
    }

    private WebApplicationException wrapException(Exception e) throws WebApplicationException {

        Throwable cause = Throwables.getRootCause(e);
        if (cause instanceof ConstraintViolationException) {
            return new WebApplicationException("Invalid constraints on input: " + cause.getMessage(), 400);
        } else {
            return new WebApplicationException("Internal error", 500);
        }
    }

    //----------------------- DEPRECATED METHODS ----------------------------//

    @Override
    public Response deprecatedGetById(Long id) {
        return Response.status(301)
                .location(UriBuilder.fromUri("categories/" + id).build())
                .build();
    }
}
