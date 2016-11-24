package no.westerdals.quiz;

import no.westerdals.quiz.ejb.QuizEJB;
import no.westerdals.quiz.ejb.RootCategoryEJB;
import no.westerdals.quiz.ejb.SubCategoryEJB;
import no.westerdals.quiz.ejb.SubSubCategoryEJB;
import no.westerdals.quiz.entity.RootCategory;
import no.westerdals.quiz.entity.SubSubCategory;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Created by tanja on 10/26/2016.
 */
@RunWith(Arquillian.class)
public class RootCategoryEJBTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "no.westerdals.quiz.ejb")
                .addPackages(true, "no.westerdals.quiz.entity")
                .addAsResource("META-INF/persistence.xml");
    }

    @Inject
    private RootCategoryEJB rootCategoryEJB;
    @Inject
    private SubCategoryEJB subCategoryEJB;
    @Inject
    private SubSubCategoryEJB subSubCategoryEJB;
    @Inject
    private QuizEJB quizEJB;


    @Before
    @After
    public void cleanDatabase() {
        quizEJB.getAll().stream().forEach(c -> quizEJB.deleteQuizEntity(c.getQuizId()));
        subSubCategoryEJB.getAll().stream().forEach(c -> subSubCategoryEJB.deleteSubSubCategory(c.getId()));
        subCategoryEJB.getAll().stream().forEach(c -> subCategoryEJB.deleteSubCategory(c.getId()));
        rootCategoryEJB.getAll().stream().forEach(c -> rootCategoryEJB.deleteRootCategory(c.getId()));
        assertEquals(0, rootCategoryEJB.getAll().size());
    }

    @Test
    public void testCleanDB() {
        int n = rootCategoryEJB.getAll().size();
        assertEquals(0, n);
    }

    @Test
    public void testCreateRootCategory() {
        int n = rootCategoryEJB.getAll().size();
        assertEquals(0, n);
        String categoryName = "Computer Science";
        Long id = rootCategoryEJB.createRootCategory(categoryName);

        int updatedDB = rootCategoryEJB.getAll().size();
        assertEquals(1, updatedDB);
    }

    @Test
    public void testGetAll() {
        int n = rootCategoryEJB.getAll().size();
        assertEquals(0, n);
        String categoryName = "Computer Science";
        Long id = rootCategoryEJB.createRootCategory(categoryName);

        int updatedDB = rootCategoryEJB.getAll().size();
        assertEquals(1, updatedDB);
        assertEquals(categoryName, rootCategoryEJB.findRootCategory(id).getCategoryName());

        Long id2 = rootCategoryEJB.createRootCategory("Test2");
        RootCategory rootCategory = rootCategoryEJB.findRootCategory(id2);
        assertEquals(2, rootCategoryEJB.getAll().size());
        assertTrue(rootCategoryEJB.getAll().contains(rootCategory));

    }
}
