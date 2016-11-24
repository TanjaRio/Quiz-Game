package no.westerdals.quiz;

import no.westerdals.quiz.ejb.QuizEJB;
import no.westerdals.quiz.ejb.RootCategoryEJB;
import no.westerdals.quiz.ejb.SubCategoryEJB;
import no.westerdals.quiz.ejb.SubSubCategoryEJB;
import no.westerdals.quiz.entity.QuizEntity;
import no.westerdals.quiz.entity.RootCategory;
import no.westerdals.quiz.entity.SubCategory;
import no.westerdals.quiz.entity.SubSubCategory;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@RunWith(Arquillian.class)
public class QuizEJBTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "no.westerdals.quiz.ejb")
                .addPackages(true, "no.westerdals.quiz.entity")
                //.addClasses(QuizEJB.class, RootCategory.class, SubCategoryEJB.class, SubSubCategoryEJB.class)
                //.addClasses(QuizEntity.class, RootCategory.class, SubSubCategory.class, SubCategory.class)
                .addAsResource("META-INF/persistence.xml");

    }

    @EJB
    private QuizEJB quizEJB;

    @EJB
    private RootCategoryEJB rootCategoryEJB;

    @EJB
    private SubSubCategoryEJB subSubCategoryEJB;

    @EJB
    private SubCategoryEJB subCategoryEJB;


    @Before
    @After
    public void cleanDatabase() {
        quizEJB.getAll().stream().forEach(c -> quizEJB.deleteQuizEntity(c.getQuizId()));
        subSubCategoryEJB.getAll().stream().forEach(c -> subSubCategoryEJB.deleteSubSubCategory(c.getId()));
        subCategoryEJB.getAll().stream().forEach(c -> subCategoryEJB.deleteSubCategory(c.getId()));
        rootCategoryEJB.getAll().stream().forEach(c -> rootCategoryEJB.deleteRootCategory(c.getId()));
        assertEquals(0, rootCategoryEJB.getAll().size());
    }

    /*public String createCategories(String rootCategory, String subCategory, String subSubCategory) {
        rootCategoryEJB.createRootCategory(rootCategory);
        subCategoryEJB.createSubCategory(subCategory, rootCategory);
        return subSubCategoryEJB.createSubSubCategory(subSubCategory, subCategory);

    }*/

    @Test
    public void testCleanDB() {
        int a = quizEJB.getAll().size();
        assertEquals(0, a);

        int b = subSubCategoryEJB.getAll().size();
        assertEquals(0, b);

        int c = subCategoryEJB.getAll().size();
        assertEquals(0, c);

        int d = rootCategoryEJB.getAll().size();
        assertEquals(0, d);
    }

    @Test
    public void testCreateQuizEntity() {
        int initialSize = quizEJB.getAll().size();
        assertEquals(0, initialSize);

        String rootCategoryName = "Computer Programming";
        String subCategoryName = "Java";
        String subSubCategoryName = "JavaEE";

        rootCategoryEJB.createRootCategory(rootCategoryName);
        subCategoryEJB.createSubCategory(subCategoryName, rootCategoryName);
        subSubCategoryEJB.createSubSubCategory(subSubCategoryName, subCategoryName);

        //createCategories("Programming", "Java", subSubCategoryName);
        String question = "test";
        List<String> answers = new ArrayList<>();
        answers.add("1");
        answers.add("2");
        answers.add("3");
        String correctAnswer = "correct answer";
        quizEJB.createQuiz(question, answers, correctAnswer, subSubCategoryName);

        int sizeAfterAddedQuiz = quizEJB.getAll().size();
        assertEquals(1, sizeAfterAddedQuiz);
    }

}
