package io.github.mportilho.sentencecompiler.syntaxtree.parser;

import io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarLexer;
import io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarParser;
import io.github.mportilho.sentencecompiler.grammar.MathematicalSentenceParserGrammarParser.StartContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;

public class SyntaxTreeParser {

    public static SyntaxTreeData parseSentence(
            String expression, OperationSyntaxTreeGenerator operationSyntaxTreeGenerator) {
        StartContext startContext = createOperationParser(CharStreams.fromString(expression), PredictionMode.SLL).start();
        return operationSyntaxTreeGenerator.createOperationSyntaxTree(startContext);
    }

    public static void validate(String expression) {
        createOperationParser(CharStreams.fromString(expression), PredictionMode.LL_EXACT_AMBIG_DETECTION).start();
    }

    private static MathematicalSentenceParserGrammarParser createOperationParser(
            CharStream expression, PredictionMode predictionMode) {
        MathematicalSentenceParserGrammarLexer lexer = new MathematicalSentenceParserGrammarLexer(expression);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ParsingErrorListener.INSTANCE);
        MathematicalSentenceParserGrammarParser parser = new MathematicalSentenceParserGrammarParser(new CommonTokenStream(lexer));
        try {
            parser.getInterpreter().setPredictionMode(predictionMode);
            parser.removeErrorListeners();
            parser.addErrorListener(ParsingErrorListener.INSTANCE);
            return parser;
        } catch (Exception e) {
            throw new IllegalStateException("Error during expression parsing", e);
        }
    }


}
