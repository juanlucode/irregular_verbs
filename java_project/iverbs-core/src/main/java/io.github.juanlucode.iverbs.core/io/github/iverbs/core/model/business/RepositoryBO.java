package io.github.iverbs.core.model.business;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.github.iverbs.commons.ArrayTools;
import io.github.iverbs.core.model.value.VerbVO;
import io.github.iverbs.core.model.enumeration.Level;
import io.github.iverbs.core.model.enumeration.VerbForm;
import io.github.iverbs.core.model.value.QuestionVO;
import io.github.iverbs.core.model.value.QuestionaryVO;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RepositoryBO {

    /**
     * Generates a questionary with a number of questions for a determinate level.
     * The verbs are random selected.
     *
     * @param _numQuestions
     * @param _level
     * @return
     */
    public static QuestionaryVO generateQuestionary(List<VerbVO> _verbs, byte _numQuestions, Level _level) {
        // list of index verb selected, used to avoid repetitions
        List<VerbVO> listSelected = new ArrayList<>();

        Random random = new Random();

        // selection verb counter
        VerbVO verbCandidate = null;

        for (var i = 0; i < _numQuestions; i++) {
            do {
                // select random verb in repository
                verbCandidate = _verbs.get(random.nextInt(_verbs.size()));
                // avoiding repetitions
            } while (listSelected.contains(verbCandidate));
            listSelected.add(verbCandidate);

        }

        // set questionaryVO with array verbs and level of questions
        QuestionaryVO questionaryVO = new QuestionaryVO(listSelected, _level);

        // when translate field is null, we need to generate options
        // for test question
        for (QuestionVO questionVO : questionaryVO.getQuestions())
            if (questionVO.getVerbResponse().get(VerbForm.TRANSLATE) == null)
                generateTranslateOps(questionVO, _verbs);

        return questionaryVO;
    }

    private static void generateTranslateOps(QuestionVO _questionVO, List<VerbVO> _verbs) {
        // the correct opt put in last position
        String[] ops = { null, null, null, _questionVO.getVerbOrigin().get(VerbForm.TRANSLATE) };
        Random random = new Random();
        boolean ok = true;
        VerbVO randomVerb;
        for (byte i = 0; i < 3; i++) {
            do {
                randomVerb = _verbs.get(random.nextInt(_verbs.size()));
                if (randomVerb.equals(_questionVO.getVerbOrigin()))
                    ok = false;
                else if (i > 0)
                    for (int j = i - 1; j >= 0; j--)
                        if (randomVerb.get(VerbForm.TRANSLATE).equals(ops[j])) {
                            ok = false;
                            break;
                        }
            } while (!ok);
            ops[i] = randomVerb.get(VerbForm.TRANSLATE);
        }
        // shuffle the array ops
        _questionVO.setTranslateOps(ArrayTools.shuffleArray(ops));
    }

    /**
     * Load repository from a resources json file.
     */
    public static List<VerbVO> load() {

        // https://mkyong.com/java/how-to-parse-json-with-gson/
        Gson gson = new Gson();
        List<VerbVO> verbs = null
                ;
        try (InputStream inputStream = new FileInputStream("core/repo/irregular_verbs.json")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            Type listType = new TypeToken<List<VerbVO>>() {
            }.getType();
            // Convert JSON File to List Java Object
            verbs = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return verbs;
    }
}
