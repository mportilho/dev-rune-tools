package io.github.mportilho.sentencecompiler.executor;

import io.github.mportilho.sentencecompiler.MathSentence;

public interface MathSentenceFactory {

    MathSentence create(MathFormula mathFormula);

}
