package io.github.iverbs.core.model.business;

import io.github.iverbs.core.model.QuestionaryResult;
import io.github.iverbs.core.model.value.QuestionVO;

public class QuestionaryBO {

    public static QuestionaryResult check(QuestionVO[] _questions) {
        var total = 0;
        var correct = 0;
        for ( QuestionVO questionVO : _questions ) {
            total++;
            if ( questionVO.isCorrect() )
                correct++;
        }
        return new QuestionaryResult(total, correct);

    }
}
