package no.westerdals.restApi.api;

import no.westerdals.quiz.ejb.RootCategoryEJB;
import no.westerdals.restApi.dto.CategoryConverter;
import no.westerdals.restApi.dto.CategoryDto;

import javax.ejb.EJB;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
public class CategoriesRestImpl {
    @EJB
    private RootCategoryEJB ejb;

    @Override
    public List<CategoryDto> get() {
        return CategoryConverter.transform(ejb.getAll());

    }
}
