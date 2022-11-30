package io.github.iverbs.core.model.business;

import io.github.iverbs.core.model.value.QuestionaryResultVO;
import io.github.iverbs.core.model.value.QuestionVO;

public class QuestionaryBO {

    public static QuestionaryResultVO check(QuestionVO[] _questions) {
        var total = 0;
        var correct = 0;
        for ( QuestionVO questionVO : _questions ) {
            total++;
            if ( questionVO.isCorrect() )
                correct++;
        }
        return new QuestionaryResultVO(total, correct);

    }
}
