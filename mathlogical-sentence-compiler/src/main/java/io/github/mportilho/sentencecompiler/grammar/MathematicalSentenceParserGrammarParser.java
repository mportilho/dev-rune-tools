// Generated from C:/dev/git/dev-rune-tools/mathlogical-sentence-compiler/src/main/resources\MathematicalSentenceParserGrammar.g4 by ANTLR 4.12.0

    package io.github.mportilho.sentencecompiler.grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MathematicalSentenceParserGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, THEN=2, ELSE=3, ELSEIF=4, ENDIF=5, AND=6, OR=7, XOR=8, XNOR=9, NAND=10, 
		NOR=11, TRUE=12, FALSE=13, MULT=14, DIV=15, PLUS=16, MINUS=17, PERCENT=18, 
		MODULO=19, MODULUS=20, EXCLAMATION=21, EXPONENTIATION=22, ROOT=23, SQRT=24, 
		BINARY_LOGARITHM=25, NATURAL_LOGARITHM=26, COMMOM_LOGARITHM=27, LOGARITHM=28, 
		SUMMATION=29, PRODUCT_SEQUENCE=30, SUMMATION_VARIABLE=31, PRODUCT_SEQUENCE_VARIABLE=32, 
		MINUS_PARENTHESIS=33, PI=34, EULER=35, DEGREE=36, GT=37, GE=38, LT=39, 
		LE=40, EQ=41, NEQ=42, NOT=43, R_UP=44, R_DOWN=45, R_CEILING=46, R_FLOOR=47, 
		R_HALF_UP=48, R_HALF_DOWN=49, R_HALF_EVEN=50, R_UNNECESSARY=51, DATE_OPERATIONS=52, 
		TIME_OPERATIONS=53, NOW_DATE=54, NOW_TIME=55, NOW_DATETIME=56, PLUS_DAYS=57, 
		PLUS_MONTHS=58, PLUS_YEARS=59, PLUS_HOURS=60, PLUS_MINUTES=61, PLUS_SECONDS=62, 
		MINUS_DAYS=63, MINUS_MONTHS=64, MINUS_YEARS=65, MINUS_HOURS=66, MINUS_MINUTES=67, 
		MINUS_SECONDS=68, SET_DAYS=69, SET_MONTHS=70, SET_YEARS=71, SET_HOURS=72, 
		SET_MINUTES=73, SET_SECONDS=74, LPAREN=75, RPAREN=76, LBLACKET=77, RBLACKET=78, 
		QUOTES=79, ASSIGNMENT=80, COMMA=81, SEMI=82, PERIOD=83, CONTAINS=84, CACHE_FUNCTION_PREFIX=85, 
		IDENTIFIER=86, NEGATIVE_IDENTIFIER=87, STRING=88, NUMBER=89, POSITIVE=90, 
		DATE=91, TIME=92, DATETIME=93, BOOLEAN_TYPE=94, NUMBER_TYPE=95, STRING_TYPE=96, 
		DATE_TYPE=97, TIME_TYPE=98, DATETIME_TYPE=99, VECTOR_TYPE=100, COMMENT=101, 
		WS=102;
	public static final int
		RULE_start = 0, RULE_mathStart = 1, RULE_logicalStart = 2, RULE_assignmentExpression = 3, 
		RULE_logicalExpression = 4, RULE_mathExpression = 5, RULE_mathSpecificFunction = 6, 
		RULE_logarithmFunction = 7, RULE_roundingFunction = 8, RULE_sequenceFunction = 9, 
		RULE_dateOperation = 10, RULE_timeOperation = 11, RULE_dateTimeOperation = 12, 
		RULE_function = 13, RULE_comparisonOperator = 14, RULE_logicalOperator = 15, 
		RULE_allEntityTypes = 16, RULE_logicalEntity = 17, RULE_numericEntity = 18, 
		RULE_stringEntity = 19, RULE_dateEntity = 20, RULE_timeEntity = 21, RULE_dateTimeEntity = 22, 
		RULE_vectorEntity = 23, RULE_vectorOfVariables = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "mathStart", "logicalStart", "assignmentExpression", "logicalExpression", 
			"mathExpression", "mathSpecificFunction", "logarithmFunction", "roundingFunction", 
			"sequenceFunction", "dateOperation", "timeOperation", "dateTimeOperation", 
			"function", "comparisonOperator", "logicalOperator", "allEntityTypes", 
			"logicalEntity", "numericEntity", "stringEntity", "dateEntity", "timeEntity", 
			"dateTimeEntity", "vectorEntity", "vectorOfVariables"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'then'", "'else'", "'elsif'", "'endif'", "'and'", "'or'", 
			"'xor'", "'xnor'", "'nand'", "'nor'", "'true'", "'false'", "'*'", "'/'", 
			"'+'", "'-'", "'%'", "'mod'", "'|'", "'!'", "'^'", null, "'sqrt'", "'lb'", 
			"'ln'", "'log10'", "'log'", "'S['", "'P['", "'S'", "'P'", null, null, 
			null, null, "'>'", "'>='", "'<'", "'<='", "'='", null, null, "'up'", 
			"'down'", "'ceiling'", "'floor'", "'halfUp'", "'halfDown'", "'halfEven'", 
			"'unnecessary'", null, null, "'currDate'", "'currTime'", "'currDateTime'", 
			"'plusDays'", "'plusMonths'", "'plusYears'", "'plusHours'", "'plusMinutes'", 
			"'plusSeconds'", "'minusDays'", "'minusMonths'", "'minusYears'", "'minusHours'", 
			"'minusMinutes'", "'minusSeconds'", "'setDays'", "'setMonths'", "'setYears'", 
			"'setHours'", "'setMinutes'", "'setSeconds'", "'('", "')'", "'['", "']'", 
			"'''", "':='", "','", "';'", "'.'", "'contains'", "'$.'", null, null, 
			null, null, null, null, null, null, "'<bool>'", "'<number>'", "'<text>'", 
			"'<date>'", "'<time>'", "'<datetime>'", "'<vector>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "THEN", "ELSE", "ELSEIF", "ENDIF", "AND", "OR", "XOR", "XNOR", 
			"NAND", "NOR", "TRUE", "FALSE", "MULT", "DIV", "PLUS", "MINUS", "PERCENT", 
			"MODULO", "MODULUS", "EXCLAMATION", "EXPONENTIATION", "ROOT", "SQRT", 
			"BINARY_LOGARITHM", "NATURAL_LOGARITHM", "COMMOM_LOGARITHM", "LOGARITHM", 
			"SUMMATION", "PRODUCT_SEQUENCE", "SUMMATION_VARIABLE", "PRODUCT_SEQUENCE_VARIABLE", 
			"MINUS_PARENTHESIS", "PI", "EULER", "DEGREE", "GT", "GE", "LT", "LE", 
			"EQ", "NEQ", "NOT", "R_UP", "R_DOWN", "R_CEILING", "R_FLOOR", "R_HALF_UP", 
			"R_HALF_DOWN", "R_HALF_EVEN", "R_UNNECESSARY", "DATE_OPERATIONS", "TIME_OPERATIONS", 
			"NOW_DATE", "NOW_TIME", "NOW_DATETIME", "PLUS_DAYS", "PLUS_MONTHS", "PLUS_YEARS", 
			"PLUS_HOURS", "PLUS_MINUTES", "PLUS_SECONDS", "MINUS_DAYS", "MINUS_MONTHS", 
			"MINUS_YEARS", "MINUS_HOURS", "MINUS_MINUTES", "MINUS_SECONDS", "SET_DAYS", 
			"SET_MONTHS", "SET_YEARS", "SET_HOURS", "SET_MINUTES", "SET_SECONDS", 
			"LPAREN", "RPAREN", "LBLACKET", "RBLACKET", "QUOTES", "ASSIGNMENT", "COMMA", 
			"SEMI", "PERIOD", "CONTAINS", "CACHE_FUNCTION_PREFIX", "IDENTIFIER", 
			"NEGATIVE_IDENTIFIER", "STRING", "NUMBER", "POSITIVE", "DATE", "TIME", 
			"DATETIME", "BOOLEAN_TYPE", "NUMBER_TYPE", "STRING_TYPE", "DATE_TYPE", 
			"TIME_TYPE", "DATETIME_TYPE", "VECTOR_TYPE", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MathematicalSentenceParserGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MathematicalSentenceParserGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public MathStartContext mathStart() {
			return getRuleContext(MathStartContext.class,0);
		}
		public LogicalStartContext logicalStart() {
			return getRuleContext(LogicalStartContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				mathStart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				logicalStart();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MathStartContext extends ParserRuleContext {
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MathematicalSentenceParserGrammarParser.EOF, 0); }
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public MathStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterMathStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitMathStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitMathStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathStartContext mathStart() throws RecognitionException {
		MathStartContext _localctx = new MathStartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mathStart);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(54);
					assignmentExpression();
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(60);
			mathExpression(0);
			setState(61);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalStartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MathematicalSentenceParserGrammarParser.EOF, 0); }
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public LogicalStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogicalStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogicalStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogicalStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalStartContext logicalStart() throws RecognitionException {
		LogicalStartContext _localctx = new LogicalStartContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_logicalStart);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(63);
					assignmentExpression();
					}
					} 
				}
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 130595661806579714L) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 33520641L) != 0)) {
				{
				setState(69);
				logicalExpression(0);
				}
			}

			setState(72);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
	 
		public AssignmentExpressionContext() { }
		public void copyFrom(AssignmentExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignOperationContext extends AssignmentExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode EQ() { return getToken(MathematicalSentenceParserGrammarParser.EQ, 0); }
		public AllEntityTypesContext allEntityTypes() {
			return getRuleContext(AllEntityTypesContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MathematicalSentenceParserGrammarParser.SEMI, 0); }
		public AssignOperationContext(AssignmentExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterAssignOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitAssignOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitAssignOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DestructuringAssignmentContext extends AssignmentExpressionContext {
		public VectorOfVariablesContext vectorOfVariables() {
			return getRuleContext(VectorOfVariablesContext.class,0);
		}
		public TerminalNode EQ() { return getToken(MathematicalSentenceParserGrammarParser.EQ, 0); }
		public TerminalNode SEMI() { return getToken(MathematicalSentenceParserGrammarParser.SEMI, 0); }
		public VectorEntityContext vectorEntity() {
			return getRuleContext(VectorEntityContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public DestructuringAssignmentContext(AssignmentExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDestructuringAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDestructuringAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDestructuringAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignmentExpression);
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new AssignOperationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(IDENTIFIER);
				setState(75);
				match(EQ);
				setState(76);
				allEntityTypes();
				setState(77);
				match(SEMI);
				}
				break;
			case LBLACKET:
				_localctx = new DestructuringAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				vectorOfVariables();
				setState(80);
				match(EQ);
				setState(83);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(81);
					vectorEntity();
					}
					break;
				case 2:
					{
					setState(82);
					function();
					}
					break;
				}
				setState(85);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExpressionContext extends ParserRuleContext {
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
	 
		public LogicalExpressionContext() { }
		public void copyFrom(LogicalExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeExpressionContext extends LogicalExpressionContext {
		public List<DateTimeOperationContext> dateTimeOperation() {
			return getRuleContexts(DateTimeOperationContext.class);
		}
		public DateTimeOperationContext dateTimeOperation(int i) {
			return getRuleContext(DateTimeOperationContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public DateTimeExpressionContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateTimeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateTimeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateTimeExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringExpressionContext extends LogicalExpressionContext {
		public List<StringEntityContext> stringEntity() {
			return getRuleContexts(StringEntityContext.class);
		}
		public StringEntityContext stringEntity(int i) {
			return getRuleContext(StringEntityContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public StringExpressionContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitStringExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalValueContext extends LogicalExpressionContext {
		public LogicalEntityContext logicalEntity() {
			return getRuleContext(LogicalEntityContext.class,0);
		}
		public LogicalValueContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogicalValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogicalValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogicalValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicExpressionContext extends LogicalExpressionContext {
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public LogicalOperatorContext logicalOperator() {
			return getRuleContext(LogicalOperatorContext.class,0);
		}
		public LogicExpressionContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogicExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogicExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateExpressionContext extends LogicalExpressionContext {
		public List<DateOperationContext> dateOperation() {
			return getRuleContexts(DateOperationContext.class);
		}
		public DateOperationContext dateOperation(int i) {
			return getRuleContext(DateOperationContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public DateExpressionContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends LogicalExpressionContext {
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(MathematicalSentenceParserGrammarParser.NOT, 0); }
		public TerminalNode EXCLAMATION() { return getToken(MathematicalSentenceParserGrammarParser.EXCLAMATION, 0); }
		public NotExpressionContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonMathExpressionContext extends LogicalExpressionContext {
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ComparisonMathExpressionContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterComparisonMathExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitComparisonMathExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitComparisonMathExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimeExpressionContext extends LogicalExpressionContext {
		public List<TimeOperationContext> timeOperation() {
			return getRuleContexts(TimeOperationContext.class);
		}
		public TimeOperationContext timeOperation(int i) {
			return getRuleContext(TimeOperationContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public TimeExpressionContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterTimeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitTimeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitTimeExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalParenthesisContext extends LogicalExpressionContext {
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public LogicalParenthesisContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogicalParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogicalParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogicalParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		return logicalExpression(0);
	}

	private LogicalExpressionContext logicalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, _parentState);
		LogicalExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_logicalExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(90);
				_la = _input.LA(1);
				if ( !(_la==EXCLAMATION || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(91);
				logicalExpression(9);
				}
				break;
			case 2:
				{
				_localctx = new ComparisonMathExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				mathExpression(0);
				setState(93);
				comparisonOperator();
				setState(94);
				mathExpression(0);
				}
				break;
			case 3:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				stringEntity();
				setState(97);
				comparisonOperator();
				setState(98);
				stringEntity();
				}
				break;
			case 4:
				{
				_localctx = new DateExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				dateOperation();
				setState(101);
				comparisonOperator();
				setState(102);
				dateOperation();
				}
				break;
			case 5:
				{
				_localctx = new TimeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				timeOperation();
				setState(105);
				comparisonOperator();
				setState(106);
				timeOperation();
				}
				break;
			case 6:
				{
				_localctx = new DateTimeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				dateTimeOperation();
				setState(109);
				comparisonOperator();
				setState(110);
				dateTimeOperation();
				}
				break;
			case 7:
				{
				_localctx = new LogicalParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				match(LPAREN);
				setState(113);
				logicalExpression(0);
				setState(114);
				match(RPAREN);
				}
				break;
			case 8:
				{
				_localctx = new LogicalValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				logicalEntity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(125);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicExpressionContext(new LogicalExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
					setState(119);
					if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
					setState(120);
					logicalOperator();
					setState(121);
					logicalExpression(9);
					}
					} 
				}
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MathExpressionContext extends ParserRuleContext {
		public MathExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathExpression; }
	 
		public MathExpressionContext() { }
		public void copyFrom(MathExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DaysSubtractionExpressionContext extends MathExpressionContext {
		public List<DateEntityContext> dateEntity() {
			return getRuleContexts(DateEntityContext.class);
		}
		public DateEntityContext dateEntity(int i) {
			return getRuleContext(DateEntityContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(MathematicalSentenceParserGrammarParser.MINUS, 0); }
		public DaysSubtractionExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDaysSubtractionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDaysSubtractionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDaysSubtractionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModulusExpressionContext extends MathExpressionContext {
		public List<TerminalNode> MODULUS() { return getTokens(MathematicalSentenceParserGrammarParser.MODULUS); }
		public TerminalNode MODULUS(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.MODULUS, i);
		}
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public ModulusExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterModulusExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitModulusExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitModulusExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MathParenthesisContext extends MathExpressionContext {
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public MathParenthesisContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterMathParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitMathParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitMathParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationExpressionContext extends MathExpressionContext {
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TerminalNode MULT() { return getToken(MathematicalSentenceParserGrammarParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MathematicalSentenceParserGrammarParser.DIV, 0); }
		public TerminalNode MODULO() { return getToken(MathematicalSentenceParserGrammarParser.MODULO, 0); }
		public MultiplicationExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterMultiplicationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitMultiplicationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitMultiplicationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MathSpecificExpressionContext extends MathExpressionContext {
		public MathSpecificFunctionContext mathSpecificFunction() {
			return getRuleContext(MathSpecificFunctionContext.class,0);
		}
		public MathSpecificExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterMathSpecificExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitMathSpecificExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitMathSpecificExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactorialExpressionContext extends MathExpressionContext {
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode EXCLAMATION() { return getToken(MathematicalSentenceParserGrammarParser.EXCLAMATION, 0); }
		public FactorialExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterFactorialExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitFactorialExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitFactorialExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegateMathParenthesisContext extends MathExpressionContext {
		public TerminalNode MINUS_PARENTHESIS() { return getToken(MathematicalSentenceParserGrammarParser.MINUS_PARENTHESIS, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public NegateMathParenthesisContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterNegateMathParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitNegateMathParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitNegateMathParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SquareRootExpressionContext extends MathExpressionContext {
		public TerminalNode SQRT() { return getToken(MathematicalSentenceParserGrammarParser.SQRT, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public SquareRootExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterSquareRootExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitSquareRootExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitSquareRootExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PercentExpressionContext extends MathExpressionContext {
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode PERCENT() { return getToken(MathematicalSentenceParserGrammarParser.PERCENT, 0); }
		public PercentExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterPercentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitPercentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitPercentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RootExpressionContext extends MathExpressionContext {
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TerminalNode ROOT() { return getToken(MathematicalSentenceParserGrammarParser.ROOT, 0); }
		public RootExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterRootExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitRootExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitRootExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SumExpressionContext extends MathExpressionContext {
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(MathematicalSentenceParserGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MathematicalSentenceParserGrammarParser.MINUS, 0); }
		public SumExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterSumExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitSumExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitSumExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DegreeExpressionContext extends MathExpressionContext {
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode DEGREE() { return getToken(MathematicalSentenceParserGrammarParser.DEGREE, 0); }
		public DegreeExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDegreeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDegreeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDegreeExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberValueContext extends MathExpressionContext {
		public NumericEntityContext numericEntity() {
			return getRuleContext(NumericEntityContext.class,0);
		}
		public NumberValueContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterNumberValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitNumberValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitNumberValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExponentiationExpressionContext extends MathExpressionContext {
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TerminalNode EXPONENTIATION() { return getToken(MathematicalSentenceParserGrammarParser.EXPONENTIATION, 0); }
		public ExponentiationExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterExponentiationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitExponentiationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitExponentiationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathExpressionContext mathExpression() throws RecognitionException {
		return mathExpression(0);
	}

	private MathExpressionContext mathExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MathExpressionContext _localctx = new MathExpressionContext(_ctx, _parentState);
		MathExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_mathExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new MathParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(129);
				match(LPAREN);
				setState(130);
				mathExpression(0);
				setState(131);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new NegateMathParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				match(MINUS_PARENTHESIS);
				setState(134);
				mathExpression(0);
				setState(135);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new SquareRootExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(SQRT);
				setState(138);
				match(LPAREN);
				setState(139);
				mathExpression(0);
				setState(140);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new DaysSubtractionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				dateEntity();
				setState(143);
				match(MINUS);
				setState(144);
				dateEntity();
				}
				break;
			case 5:
				{
				_localctx = new ModulusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(MODULUS);
				setState(147);
				mathExpression(0);
				setState(148);
				match(MODULUS);
				}
				break;
			case 6:
				{
				_localctx = new MathSpecificExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				mathSpecificFunction();
				}
				break;
			case 7:
				{
				_localctx = new NumberValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				numericEntity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(172);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new RootExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(154);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(155);
						match(ROOT);
						setState(156);
						mathExpression(11);
						}
						break;
					case 2:
						{
						_localctx = new ExponentiationExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(157);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(158);
						match(EXPONENTIATION);
						setState(159);
						mathExpression(8);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicationExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(160);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(161);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 573440L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(162);
						mathExpression(8);
						}
						break;
					case 4:
						{
						_localctx = new SumExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(163);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(164);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(165);
						mathExpression(7);
						}
						break;
					case 5:
						{
						_localctx = new PercentExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(166);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(167);
						match(PERCENT);
						}
						break;
					case 6:
						{
						_localctx = new FactorialExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(168);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(169);
						match(EXCLAMATION);
						}
						break;
					case 7:
						{
						_localctx = new DegreeExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(170);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(171);
						match(DEGREE);
						}
						break;
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MathSpecificFunctionContext extends ParserRuleContext {
		public MathSpecificFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathSpecificFunction; }
	 
		public MathSpecificFunctionContext() { }
		public void copyFrom(MathSpecificFunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SequenceExpressionContext extends MathSpecificFunctionContext {
		public SequenceFunctionContext sequenceFunction() {
			return getRuleContext(SequenceFunctionContext.class,0);
		}
		public SequenceExpressionContext(MathSpecificFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterSequenceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitSequenceExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitSequenceExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogarithmExpressionContext extends MathSpecificFunctionContext {
		public LogarithmFunctionContext logarithmFunction() {
			return getRuleContext(LogarithmFunctionContext.class,0);
		}
		public LogarithmExpressionContext(MathSpecificFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogarithmExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogarithmExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogarithmExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RoundingExpressionContext extends MathSpecificFunctionContext {
		public RoundingFunctionContext roundingFunction() {
			return getRuleContext(RoundingFunctionContext.class,0);
		}
		public RoundingExpressionContext(MathSpecificFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterRoundingExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitRoundingExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitRoundingExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathSpecificFunctionContext mathSpecificFunction() throws RecognitionException {
		MathSpecificFunctionContext _localctx = new MathSpecificFunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mathSpecificFunction);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BINARY_LOGARITHM:
			case NATURAL_LOGARITHM:
			case COMMOM_LOGARITHM:
			case LOGARITHM:
				_localctx = new LogarithmExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				logarithmFunction();
				}
				break;
			case R_UP:
			case R_DOWN:
			case R_CEILING:
			case R_FLOOR:
			case R_HALF_UP:
			case R_HALF_DOWN:
			case R_HALF_EVEN:
			case R_UNNECESSARY:
				_localctx = new RoundingExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				roundingFunction();
				}
				break;
			case SUMMATION:
			case PRODUCT_SEQUENCE:
				_localctx = new SequenceExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				sequenceFunction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogarithmFunctionContext extends ParserRuleContext {
		public LogarithmFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logarithmFunction; }
	 
		public LogarithmFunctionContext() { }
		public void copyFrom(LogarithmFunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableLogarithmContext extends LogarithmFunctionContext {
		public TerminalNode LOGARITHM() { return getToken(MathematicalSentenceParserGrammarParser.LOGARITHM, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MathematicalSentenceParserGrammarParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public VariableLogarithmContext(LogarithmFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterVariableLogarithm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitVariableLogarithm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitVariableLogarithm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FixedLogarithmContext extends LogarithmFunctionContext {
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public TerminalNode BINARY_LOGARITHM() { return getToken(MathematicalSentenceParserGrammarParser.BINARY_LOGARITHM, 0); }
		public TerminalNode NATURAL_LOGARITHM() { return getToken(MathematicalSentenceParserGrammarParser.NATURAL_LOGARITHM, 0); }
		public TerminalNode COMMOM_LOGARITHM() { return getToken(MathematicalSentenceParserGrammarParser.COMMOM_LOGARITHM, 0); }
		public FixedLogarithmContext(LogarithmFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterFixedLogarithm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitFixedLogarithm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitFixedLogarithm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogarithmFunctionContext logarithmFunction() throws RecognitionException {
		LogarithmFunctionContext _localctx = new LogarithmFunctionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_logarithmFunction);
		int _la;
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BINARY_LOGARITHM:
			case NATURAL_LOGARITHM:
			case COMMOM_LOGARITHM:
				_localctx = new FixedLogarithmContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 234881024L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(183);
				match(LPAREN);
				setState(184);
				mathExpression(0);
				setState(185);
				match(RPAREN);
				}
				break;
			case LOGARITHM:
				_localctx = new VariableLogarithmContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(LOGARITHM);
				setState(188);
				match(LPAREN);
				setState(189);
				mathExpression(0);
				setState(190);
				match(COMMA);
				setState(191);
				mathExpression(0);
				setState(192);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RoundingFunctionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MathematicalSentenceParserGrammarParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public TerminalNode R_UP() { return getToken(MathematicalSentenceParserGrammarParser.R_UP, 0); }
		public TerminalNode R_DOWN() { return getToken(MathematicalSentenceParserGrammarParser.R_DOWN, 0); }
		public TerminalNode R_CEILING() { return getToken(MathematicalSentenceParserGrammarParser.R_CEILING, 0); }
		public TerminalNode R_FLOOR() { return getToken(MathematicalSentenceParserGrammarParser.R_FLOOR, 0); }
		public TerminalNode R_HALF_UP() { return getToken(MathematicalSentenceParserGrammarParser.R_HALF_UP, 0); }
		public TerminalNode R_HALF_DOWN() { return getToken(MathematicalSentenceParserGrammarParser.R_HALF_DOWN, 0); }
		public TerminalNode R_HALF_EVEN() { return getToken(MathematicalSentenceParserGrammarParser.R_HALF_EVEN, 0); }
		public TerminalNode R_UNNECESSARY() { return getToken(MathematicalSentenceParserGrammarParser.R_UNNECESSARY, 0); }
		public RoundingFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roundingFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterRoundingFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitRoundingFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitRoundingFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoundingFunctionContext roundingFunction() throws RecognitionException {
		RoundingFunctionContext _localctx = new RoundingFunctionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_roundingFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4486007441326080L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(197);
			match(LPAREN);
			setState(198);
			mathExpression(0);
			setState(199);
			match(COMMA);
			setState(200);
			mathExpression(0);
			setState(201);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SequenceFunctionContext extends ParserRuleContext {
		public VectorEntityContext vectorEntity() {
			return getRuleContext(VectorEntityContext.class,0);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public TerminalNode SUMMATION() { return getToken(MathematicalSentenceParserGrammarParser.SUMMATION, 0); }
		public TerminalNode PRODUCT_SEQUENCE() { return getToken(MathematicalSentenceParserGrammarParser.PRODUCT_SEQUENCE, 0); }
		public SequenceFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequenceFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterSequenceFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitSequenceFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitSequenceFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceFunctionContext sequenceFunction() throws RecognitionException {
		SequenceFunctionContext _localctx = new SequenceFunctionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sequenceFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_la = _input.LA(1);
			if ( !(_la==SUMMATION || _la==PRODUCT_SEQUENCE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(204);
			vectorEntity();
			setState(205);
			match(RBLACKET);
			setState(206);
			match(LPAREN);
			setState(207);
			mathExpression(0);
			setState(208);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateOperationContext extends ParserRuleContext {
		public DateOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateOperation; }
	 
		public DateOperationContext() { }
		public void copyFrom(DateOperationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateParenthesisContext extends DateOperationContext {
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public DateOperationContext dateOperation() {
			return getRuleContext(DateOperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public DateParenthesisContext(DateOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateFunctionContext extends DateOperationContext {
		public DateEntityContext dateEntity() {
			return getRuleContext(DateEntityContext.class,0);
		}
		public List<TerminalNode> DATE_OPERATIONS() { return getTokens(MathematicalSentenceParserGrammarParser.DATE_OPERATIONS); }
		public TerminalNode DATE_OPERATIONS(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.DATE_OPERATIONS, i);
		}
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public DateFunctionContext(DateOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateOperationContext dateOperation() throws RecognitionException {
		DateOperationContext _localctx = new DateOperationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dateOperation);
		try {
			int _alt;
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new DateParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(LPAREN);
				setState(211);
				dateOperation();
				setState(212);
				match(RPAREN);
				}
				break;
			case IF:
			case NOW_DATE:
			case CACHE_FUNCTION_PREFIX:
			case IDENTIFIER:
			case DATE:
			case DATE_TYPE:
				_localctx = new DateFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				dateEntity();
				setState(224);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(215);
					match(DATE_OPERATIONS);
					setState(216);
					mathExpression(0);
					setState(221);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(217);
							match(DATE_OPERATIONS);
							setState(218);
							mathExpression(0);
							}
							} 
						}
						setState(223);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
					}
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeOperationContext extends ParserRuleContext {
		public TimeOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeOperation; }
	 
		public TimeOperationContext() { }
		public void copyFrom(TimeOperationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimeParenthesisContext extends TimeOperationContext {
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public TimeOperationContext timeOperation() {
			return getRuleContext(TimeOperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public TimeParenthesisContext(TimeOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterTimeParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitTimeParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitTimeParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimeFunctionContext extends TimeOperationContext {
		public TimeEntityContext timeEntity() {
			return getRuleContext(TimeEntityContext.class,0);
		}
		public List<TerminalNode> TIME_OPERATIONS() { return getTokens(MathematicalSentenceParserGrammarParser.TIME_OPERATIONS); }
		public TerminalNode TIME_OPERATIONS(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.TIME_OPERATIONS, i);
		}
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TimeFunctionContext(TimeOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterTimeFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitTimeFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitTimeFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeOperationContext timeOperation() throws RecognitionException {
		TimeOperationContext _localctx = new TimeOperationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_timeOperation);
		try {
			int _alt;
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new TimeParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(LPAREN);
				setState(229);
				timeOperation();
				setState(230);
				match(RPAREN);
				}
				break;
			case IF:
			case NOW_TIME:
			case CACHE_FUNCTION_PREFIX:
			case IDENTIFIER:
			case TIME:
			case TIME_TYPE:
				_localctx = new TimeFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				timeEntity();
				setState(242);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(233);
					match(TIME_OPERATIONS);
					setState(234);
					mathExpression(0);
					setState(239);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(235);
							match(TIME_OPERATIONS);
							setState(236);
							mathExpression(0);
							}
							} 
						}
						setState(241);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					}
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeOperationContext extends ParserRuleContext {
		public DateTimeOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateTimeOperation; }
	 
		public DateTimeOperationContext() { }
		public void copyFrom(DateTimeOperationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeFunctionContext extends DateTimeOperationContext {
		public DateTimeEntityContext dateTimeEntity() {
			return getRuleContext(DateTimeEntityContext.class,0);
		}
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public List<TerminalNode> DATE_OPERATIONS() { return getTokens(MathematicalSentenceParserGrammarParser.DATE_OPERATIONS); }
		public TerminalNode DATE_OPERATIONS(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.DATE_OPERATIONS, i);
		}
		public List<TerminalNode> TIME_OPERATIONS() { return getTokens(MathematicalSentenceParserGrammarParser.TIME_OPERATIONS); }
		public TerminalNode TIME_OPERATIONS(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.TIME_OPERATIONS, i);
		}
		public DateTimeFunctionContext(DateTimeOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateTimeFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateTimeFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateTimeFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeParenthesisContext extends DateTimeOperationContext {
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public DateTimeOperationContext dateTimeOperation() {
			return getRuleContext(DateTimeOperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public DateTimeParenthesisContext(DateTimeOperationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateTimeParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateTimeParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateTimeParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateTimeOperationContext dateTimeOperation() throws RecognitionException {
		DateTimeOperationContext _localctx = new DateTimeOperationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dateTimeOperation);
		int _la;
		try {
			int _alt;
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new DateTimeParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(LPAREN);
				setState(247);
				dateTimeOperation();
				setState(248);
				match(RPAREN);
				}
				break;
			case IF:
			case NOW_DATETIME:
			case CACHE_FUNCTION_PREFIX:
			case IDENTIFIER:
			case DATETIME:
			case DATETIME_TYPE:
				_localctx = new DateTimeFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				dateTimeEntity();
				setState(260);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(251);
					_la = _input.LA(1);
					if ( !(_la==DATE_OPERATIONS || _la==TIME_OPERATIONS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(252);
					mathExpression(0);
					setState(257);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(253);
							_la = _input.LA(1);
							if ( !(_la==DATE_OPERATIONS || _la==TIME_OPERATIONS) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							setState(254);
							mathExpression(0);
							}
							} 
						}
						setState(259);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					}
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public TerminalNode CACHE_FUNCTION_PREFIX() { return getToken(MathematicalSentenceParserGrammarParser.CACHE_FUNCTION_PREFIX, 0); }
		public List<AllEntityTypesContext> allEntityTypes() {
			return getRuleContexts(AllEntityTypesContext.class);
		}
		public AllEntityTypesContext allEntityTypes(int i) {
			return getRuleContext(AllEntityTypesContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MathematicalSentenceParserGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.SEMI, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CACHE_FUNCTION_PREFIX) {
				{
				setState(264);
				match(CACHE_FUNCTION_PREFIX);
				}
			}

			setState(267);
			match(IDENTIFIER);
			setState(268);
			match(LPAREN);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 130595661806579714L) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 67075077L) != 0)) {
				{
				{
				setState(269);
				allEntityTypes();
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA || _la==SEMI) {
					{
					{
					setState(270);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==SEMI) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(271);
					allEntityTypes();
					}
					}
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(MathematicalSentenceParserGrammarParser.GT, 0); }
		public TerminalNode GE() { return getToken(MathematicalSentenceParserGrammarParser.GE, 0); }
		public TerminalNode LT() { return getToken(MathematicalSentenceParserGrammarParser.LT, 0); }
		public TerminalNode LE() { return getToken(MathematicalSentenceParserGrammarParser.LE, 0); }
		public TerminalNode EQ() { return getToken(MathematicalSentenceParserGrammarParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MathematicalSentenceParserGrammarParser.NEQ, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8658654068736L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOperatorContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(MathematicalSentenceParserGrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(MathematicalSentenceParserGrammarParser.OR, 0); }
		public TerminalNode NAND() { return getToken(MathematicalSentenceParserGrammarParser.NAND, 0); }
		public TerminalNode NOR() { return getToken(MathematicalSentenceParserGrammarParser.NOR, 0); }
		public TerminalNode XOR() { return getToken(MathematicalSentenceParserGrammarParser.XOR, 0); }
		public TerminalNode XNOR() { return getToken(MathematicalSentenceParserGrammarParser.XNOR, 0); }
		public TerminalNode EQ() { return getToken(MathematicalSentenceParserGrammarParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MathematicalSentenceParserGrammarParser.NEQ, 0); }
		public LogicalOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogicalOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogicalOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogicalOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOperatorContext logicalOperator() throws RecognitionException {
		LogicalOperatorContext _localctx = new LogicalOperatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_logicalOperator);
		int _la;
		try {
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(AND);
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(OR);
				}
				break;
			case XOR:
			case XNOR:
			case NAND:
			case NOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3840L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case EQ:
			case NEQ:
				enterOuterAlt(_localctx, 4);
				{
				setState(289);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NEQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AllEntityTypesContext extends ParserRuleContext {
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public DateOperationContext dateOperation() {
			return getRuleContext(DateOperationContext.class,0);
		}
		public TimeOperationContext timeOperation() {
			return getRuleContext(TimeOperationContext.class,0);
		}
		public DateTimeOperationContext dateTimeOperation() {
			return getRuleContext(DateTimeOperationContext.class,0);
		}
		public StringEntityContext stringEntity() {
			return getRuleContext(StringEntityContext.class,0);
		}
		public VectorEntityContext vectorEntity() {
			return getRuleContext(VectorEntityContext.class,0);
		}
		public AllEntityTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allEntityTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterAllEntityTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitAllEntityTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitAllEntityTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllEntityTypesContext allEntityTypes() throws RecognitionException {
		AllEntityTypesContext _localctx = new AllEntityTypesContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_allEntityTypes);
		try {
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				mathExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				logicalExpression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(294);
				dateOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(295);
				timeOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(296);
				dateTimeOperation();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(297);
				stringEntity();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(298);
				vectorEntity();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalEntityContext extends ParserRuleContext {
		public LogicalEntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalEntity; }
	 
		public LogicalEntityContext() { }
		public void copyFrom(LogicalEntityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalDecisionExpressionContext extends LogicalEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<TerminalNode> THEN() { return getTokens(MathematicalSentenceParserGrammarParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.THEN, i);
		}
		public TerminalNode ELSE() { return getToken(MathematicalSentenceParserGrammarParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(MathematicalSentenceParserGrammarParser.ENDIF, 0); }
		public TerminalNode ELSEIF() { return getToken(MathematicalSentenceParserGrammarParser.ELSEIF, 0); }
		public LogicalDecisionExpressionContext(LogicalEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogicalDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogicalDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogicalDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalVariableContext extends LogicalEntityContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode BOOLEAN_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.BOOLEAN_TYPE, 0); }
		public LogicalVariableContext(LogicalEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogicalVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogicalVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogicalVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalConstantContext extends LogicalEntityContext {
		public TerminalNode TRUE() { return getToken(MathematicalSentenceParserGrammarParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MathematicalSentenceParserGrammarParser.FALSE, 0); }
		public LogicalConstantContext(LogicalEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogicalConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogicalConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogicalConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalFunctionResultContext extends LogicalEntityContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode BOOLEAN_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.BOOLEAN_TYPE, 0); }
		public LogicalFunctionResultContext(LogicalEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogicalFunctionResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogicalFunctionResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogicalFunctionResult(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalFunctionDecisionExpressionContext extends LogicalEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MathematicalSentenceParserGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.SEMI, i);
		}
		public LogicalFunctionDecisionExpressionContext(LogicalEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogicalFunctionDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogicalFunctionDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogicalFunctionDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalEntityContext logicalEntity() throws RecognitionException {
		LogicalEntityContext _localctx = new LogicalEntityContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logicalEntity);
		int _la;
		try {
			int _alt;
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new LogicalConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				_localctx = new LogicalDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(302);
				match(IF);
				setState(303);
				logicalExpression(0);
				setState(304);
				match(THEN);
				setState(305);
				logicalExpression(0);
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(306);
					match(ELSEIF);
					setState(307);
					logicalExpression(0);
					setState(308);
					match(THEN);
					setState(309);
					logicalExpression(0);
					}
				}

				setState(313);
				match(ELSE);
				setState(314);
				logicalExpression(0);
				setState(315);
				match(ENDIF);
				}
				break;
			case 3:
				_localctx = new LogicalFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
				match(IF);
				setState(318);
				match(LPAREN);
				setState(319);
				logicalExpression(0);
				setState(320);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(321);
				logicalExpression(0);
				setState(329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(322);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(323);
						logicalExpression(0);
						setState(324);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(325);
						logicalExpression(0);
						}
						} 
					}
					setState(331);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				}
				setState(332);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(333);
				logicalExpression(0);
				setState(334);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new LogicalFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BOOLEAN_TYPE) {
					{
					setState(336);
					match(BOOLEAN_TYPE);
					}
				}

				setState(339);
				function();
				}
				break;
			case 5:
				_localctx = new LogicalVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BOOLEAN_TYPE) {
					{
					setState(340);
					match(BOOLEAN_TYPE);
					}
				}

				setState(343);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumericEntityContext extends ParserRuleContext {
		public NumericEntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericEntity; }
	 
		public NumericEntityContext() { }
		public void copyFrom(NumericEntityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MathFunctionDecisionExpressionContext extends NumericEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MathematicalSentenceParserGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.SEMI, i);
		}
		public MathFunctionDecisionExpressionContext(NumericEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterMathFunctionDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitMathFunctionDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitMathFunctionDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumericConstantContext extends NumericEntityContext {
		public TerminalNode NUMBER() { return getToken(MathematicalSentenceParserGrammarParser.NUMBER, 0); }
		public NumericConstantContext(NumericEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterNumericConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitNumericConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitNumericConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumericFunctionResultContext extends NumericEntityContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode NUMBER_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.NUMBER_TYPE, 0); }
		public NumericFunctionResultContext(NumericEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterNumericFunctionResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitNumericFunctionResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitNumericFunctionResult(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PiConstantContext extends NumericEntityContext {
		public TerminalNode PI() { return getToken(MathematicalSentenceParserGrammarParser.PI, 0); }
		public PiConstantContext(NumericEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterPiConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitPiConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitPiConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumericVariableContext extends NumericEntityContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode NEGATIVE_IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.NEGATIVE_IDENTIFIER, 0); }
		public TerminalNode NUMBER_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.NUMBER_TYPE, 0); }
		public NumericVariableContext(NumericEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterNumericVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitNumericVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitNumericVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MathDecisionExpressionContext extends NumericEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<TerminalNode> THEN() { return getTokens(MathematicalSentenceParserGrammarParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.THEN, i);
		}
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MathematicalSentenceParserGrammarParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(MathematicalSentenceParserGrammarParser.ENDIF, 0); }
		public TerminalNode ELSEIF() { return getToken(MathematicalSentenceParserGrammarParser.ELSEIF, 0); }
		public MathDecisionExpressionContext(NumericEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterMathDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitMathDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitMathDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SummationVariableContext extends NumericEntityContext {
		public TerminalNode SUMMATION_VARIABLE() { return getToken(MathematicalSentenceParserGrammarParser.SUMMATION_VARIABLE, 0); }
		public SummationVariableContext(NumericEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterSummationVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitSummationVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitSummationVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProductSequenceVariableContext extends NumericEntityContext {
		public TerminalNode PRODUCT_SEQUENCE_VARIABLE() { return getToken(MathematicalSentenceParserGrammarParser.PRODUCT_SEQUENCE_VARIABLE, 0); }
		public ProductSequenceVariableContext(NumericEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterProductSequenceVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitProductSequenceVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitProductSequenceVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EulerConstantContext extends NumericEntityContext {
		public TerminalNode EULER() { return getToken(MathematicalSentenceParserGrammarParser.EULER, 0); }
		public EulerConstantContext(NumericEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterEulerConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitEulerConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitEulerConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericEntityContext numericEntity() throws RecognitionException {
		NumericEntityContext _localctx = new NumericEntityContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_numericEntity);
		int _la;
		try {
			int _alt;
			setState(396);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new MathDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				match(IF);
				setState(347);
				logicalExpression(0);
				setState(348);
				match(THEN);
				setState(349);
				mathExpression(0);
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(350);
					match(ELSEIF);
					setState(351);
					logicalExpression(0);
					setState(352);
					match(THEN);
					setState(353);
					mathExpression(0);
					}
				}

				setState(357);
				match(ELSE);
				setState(358);
				mathExpression(0);
				setState(359);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new MathFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				match(IF);
				setState(362);
				match(LPAREN);
				setState(363);
				logicalExpression(0);
				setState(364);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(365);
				mathExpression(0);
				setState(373);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(366);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(367);
						logicalExpression(0);
						setState(368);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(369);
						mathExpression(0);
						}
						} 
					}
					setState(375);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				}
				setState(376);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(377);
				mathExpression(0);
				setState(378);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new EulerConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(380);
				match(EULER);
				}
				break;
			case 4:
				_localctx = new PiConstantContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(381);
				match(PI);
				}
				break;
			case 5:
				_localctx = new SummationVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(382);
				match(SUMMATION_VARIABLE);
				}
				break;
			case 6:
				_localctx = new ProductSequenceVariableContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(383);
				match(PRODUCT_SEQUENCE_VARIABLE);
				}
				break;
			case 7:
				_localctx = new NumericConstantContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(384);
				match(NUMBER);
				}
				break;
			case 8:
				_localctx = new NumericFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER_TYPE) {
					{
					setState(385);
					match(NUMBER_TYPE);
					}
				}

				setState(388);
				function();
				}
				break;
			case 9:
				_localctx = new NumericVariableContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(394);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
				case NUMBER_TYPE:
					{
					setState(390);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NUMBER_TYPE) {
						{
						setState(389);
						match(NUMBER_TYPE);
						}
					}

					setState(392);
					match(IDENTIFIER);
					}
					break;
				case NEGATIVE_IDENTIFIER:
					{
					setState(393);
					match(NEGATIVE_IDENTIFIER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringEntityContext extends ParserRuleContext {
		public StringEntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringEntity; }
	 
		public StringEntityContext() { }
		public void copyFrom(StringEntityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringVariableContext extends StringEntityContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode STRING_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.STRING_TYPE, 0); }
		public StringVariableContext(StringEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterStringVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitStringVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitStringVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringConstantContext extends StringEntityContext {
		public TerminalNode STRING() { return getToken(MathematicalSentenceParserGrammarParser.STRING, 0); }
		public StringConstantContext(StringEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringDecisionExpressionContext extends StringEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<TerminalNode> THEN() { return getTokens(MathematicalSentenceParserGrammarParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.THEN, i);
		}
		public List<StringEntityContext> stringEntity() {
			return getRuleContexts(StringEntityContext.class);
		}
		public StringEntityContext stringEntity(int i) {
			return getRuleContext(StringEntityContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MathematicalSentenceParserGrammarParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(MathematicalSentenceParserGrammarParser.ENDIF, 0); }
		public TerminalNode ELSEIF() { return getToken(MathematicalSentenceParserGrammarParser.ELSEIF, 0); }
		public StringDecisionExpressionContext(StringEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterStringDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitStringDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitStringDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringFunctionDecisionExpressionContext extends StringEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<StringEntityContext> stringEntity() {
			return getRuleContexts(StringEntityContext.class);
		}
		public StringEntityContext stringEntity(int i) {
			return getRuleContext(StringEntityContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MathematicalSentenceParserGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.SEMI, i);
		}
		public StringFunctionDecisionExpressionContext(StringEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterStringFunctionDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitStringFunctionDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitStringFunctionDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringFunctionResultContext extends StringEntityContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode STRING_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.STRING_TYPE, 0); }
		public StringFunctionResultContext(StringEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterStringFunctionResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitStringFunctionResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitStringFunctionResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringEntityContext stringEntity() throws RecognitionException {
		StringEntityContext _localctx = new StringEntityContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_stringEntity);
		int _la;
		try {
			int _alt;
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				_localctx = new StringDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				match(IF);
				setState(399);
				logicalExpression(0);
				setState(400);
				match(THEN);
				setState(401);
				stringEntity();
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(402);
					match(ELSEIF);
					setState(403);
					logicalExpression(0);
					setState(404);
					match(THEN);
					setState(405);
					stringEntity();
					}
				}

				setState(409);
				match(ELSE);
				setState(410);
				stringEntity();
				setState(411);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new StringFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(413);
				match(IF);
				setState(414);
				match(LPAREN);
				setState(415);
				logicalExpression(0);
				setState(416);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(417);
				stringEntity();
				setState(425);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(418);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(419);
						logicalExpression(0);
						setState(420);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(421);
						stringEntity();
						}
						} 
					}
					setState(427);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				}
				setState(428);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(429);
				stringEntity();
				setState(430);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new StringConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(432);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new StringFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(434);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING_TYPE) {
					{
					setState(433);
					match(STRING_TYPE);
					}
				}

				setState(436);
				function();
				}
				break;
			case 5:
				_localctx = new StringVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING_TYPE) {
					{
					setState(437);
					match(STRING_TYPE);
					}
				}

				setState(440);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateEntityContext extends ParserRuleContext {
		public DateEntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateEntity; }
	 
		public DateEntityContext() { }
		public void copyFrom(DateEntityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateDecisionExpressionContext extends DateEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<TerminalNode> THEN() { return getTokens(MathematicalSentenceParserGrammarParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.THEN, i);
		}
		public List<DateOperationContext> dateOperation() {
			return getRuleContexts(DateOperationContext.class);
		}
		public DateOperationContext dateOperation(int i) {
			return getRuleContext(DateOperationContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MathematicalSentenceParserGrammarParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(MathematicalSentenceParserGrammarParser.ENDIF, 0); }
		public TerminalNode ELSEIF() { return getToken(MathematicalSentenceParserGrammarParser.ELSEIF, 0); }
		public DateDecisionExpressionContext(DateEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateCurrentValueContext extends DateEntityContext {
		public TerminalNode NOW_DATE() { return getToken(MathematicalSentenceParserGrammarParser.NOW_DATE, 0); }
		public DateCurrentValueContext(DateEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateCurrentValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateCurrentValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateCurrentValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateConstantContext extends DateEntityContext {
		public TerminalNode DATE() { return getToken(MathematicalSentenceParserGrammarParser.DATE, 0); }
		public DateConstantContext(DateEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateVariableContext extends DateEntityContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode DATE_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.DATE_TYPE, 0); }
		public DateVariableContext(DateEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateFunctionResultContext extends DateEntityContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode DATE_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.DATE_TYPE, 0); }
		public DateFunctionResultContext(DateEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateFunctionResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateFunctionResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateFunctionResult(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateFunctionDecisionExpressionContext extends DateEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<DateOperationContext> dateOperation() {
			return getRuleContexts(DateOperationContext.class);
		}
		public DateOperationContext dateOperation(int i) {
			return getRuleContext(DateOperationContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MathematicalSentenceParserGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.SEMI, i);
		}
		public DateFunctionDecisionExpressionContext(DateEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateFunctionDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateFunctionDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateFunctionDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateEntityContext dateEntity() throws RecognitionException {
		DateEntityContext _localctx = new DateEntityContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_dateEntity);
		int _la;
		try {
			int _alt;
			setState(487);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				_localctx = new DateDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				match(IF);
				setState(444);
				logicalExpression(0);
				setState(445);
				match(THEN);
				setState(446);
				dateOperation();
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(447);
					match(ELSEIF);
					setState(448);
					logicalExpression(0);
					setState(449);
					match(THEN);
					setState(450);
					dateOperation();
					}
				}

				setState(454);
				match(ELSE);
				setState(455);
				dateOperation();
				setState(456);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new DateFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
				match(IF);
				setState(459);
				match(LPAREN);
				setState(460);
				logicalExpression(0);
				setState(461);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(462);
				dateOperation();
				setState(470);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(463);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(464);
						logicalExpression(0);
						setState(465);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(466);
						dateOperation();
						}
						} 
					}
					setState(472);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				}
				setState(473);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(474);
				dateOperation();
				setState(475);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new DateConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(477);
				match(DATE);
				}
				break;
			case 4:
				_localctx = new DateCurrentValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(478);
				match(NOW_DATE);
				}
				break;
			case 5:
				_localctx = new DateVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATE_TYPE) {
					{
					setState(479);
					match(DATE_TYPE);
					}
				}

				setState(482);
				match(IDENTIFIER);
				}
				break;
			case 6:
				_localctx = new DateFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATE_TYPE) {
					{
					setState(483);
					match(DATE_TYPE);
					}
				}

				setState(486);
				function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeEntityContext extends ParserRuleContext {
		public TimeEntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeEntity; }
	 
		public TimeEntityContext() { }
		public void copyFrom(TimeEntityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimeConstantContext extends TimeEntityContext {
		public TerminalNode TIME() { return getToken(MathematicalSentenceParserGrammarParser.TIME, 0); }
		public TimeConstantContext(TimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterTimeConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitTimeConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitTimeConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimeVariableContext extends TimeEntityContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode TIME_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.TIME_TYPE, 0); }
		public TimeVariableContext(TimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterTimeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitTimeVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitTimeVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimeFunctionResultContext extends TimeEntityContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode TIME_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.TIME_TYPE, 0); }
		public TimeFunctionResultContext(TimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterTimeFunctionResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitTimeFunctionResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitTimeFunctionResult(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimeFunctionDecisionExpressionContext extends TimeEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<TimeOperationContext> timeOperation() {
			return getRuleContexts(TimeOperationContext.class);
		}
		public TimeOperationContext timeOperation(int i) {
			return getRuleContext(TimeOperationContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MathematicalSentenceParserGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.SEMI, i);
		}
		public TimeFunctionDecisionExpressionContext(TimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterTimeFunctionDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitTimeFunctionDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitTimeFunctionDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimeDecisionExpressionContext extends TimeEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<TerminalNode> THEN() { return getTokens(MathematicalSentenceParserGrammarParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.THEN, i);
		}
		public List<TimeOperationContext> timeOperation() {
			return getRuleContexts(TimeOperationContext.class);
		}
		public TimeOperationContext timeOperation(int i) {
			return getRuleContext(TimeOperationContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MathematicalSentenceParserGrammarParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(MathematicalSentenceParserGrammarParser.ENDIF, 0); }
		public TerminalNode ELSEIF() { return getToken(MathematicalSentenceParserGrammarParser.ELSEIF, 0); }
		public TimeDecisionExpressionContext(TimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterTimeDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitTimeDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitTimeDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimeCurrentValueContext extends TimeEntityContext {
		public TerminalNode NOW_TIME() { return getToken(MathematicalSentenceParserGrammarParser.NOW_TIME, 0); }
		public TimeCurrentValueContext(TimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterTimeCurrentValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitTimeCurrentValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitTimeCurrentValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeEntityContext timeEntity() throws RecognitionException {
		TimeEntityContext _localctx = new TimeEntityContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_timeEntity);
		int _la;
		try {
			int _alt;
			setState(533);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				_localctx = new TimeDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				match(IF);
				setState(490);
				logicalExpression(0);
				setState(491);
				match(THEN);
				setState(492);
				timeOperation();
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(493);
					match(ELSEIF);
					setState(494);
					logicalExpression(0);
					setState(495);
					match(THEN);
					setState(496);
					timeOperation();
					}
				}

				setState(500);
				match(ELSE);
				setState(501);
				timeOperation();
				setState(502);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new TimeFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(504);
				match(IF);
				setState(505);
				match(LPAREN);
				setState(506);
				logicalExpression(0);
				setState(507);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(508);
				timeOperation();
				setState(516);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(509);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(510);
						logicalExpression(0);
						setState(511);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(512);
						timeOperation();
						}
						} 
					}
					setState(518);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				}
				setState(519);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(520);
				timeOperation();
				setState(521);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new TimeConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(523);
				match(TIME);
				}
				break;
			case 4:
				_localctx = new TimeCurrentValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(524);
				match(NOW_TIME);
				}
				break;
			case 5:
				_localctx = new TimeVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(526);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TIME_TYPE) {
					{
					setState(525);
					match(TIME_TYPE);
					}
				}

				setState(528);
				match(IDENTIFIER);
				}
				break;
			case 6:
				_localctx = new TimeFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(530);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TIME_TYPE) {
					{
					setState(529);
					match(TIME_TYPE);
					}
				}

				setState(532);
				function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeEntityContext extends ParserRuleContext {
		public DateTimeEntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateTimeEntity; }
	 
		public DateTimeEntityContext() { }
		public void copyFrom(DateTimeEntityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeCurrentValueContext extends DateTimeEntityContext {
		public TerminalNode NOW_DATETIME() { return getToken(MathematicalSentenceParserGrammarParser.NOW_DATETIME, 0); }
		public DateTimeCurrentValueContext(DateTimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateTimeCurrentValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateTimeCurrentValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateTimeCurrentValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeConstantContext extends DateTimeEntityContext {
		public TerminalNode DATETIME() { return getToken(MathematicalSentenceParserGrammarParser.DATETIME, 0); }
		public DateTimeConstantContext(DateTimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateTimeConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateTimeConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateTimeConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeDecisionExpressionContext extends DateTimeEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<TerminalNode> THEN() { return getTokens(MathematicalSentenceParserGrammarParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.THEN, i);
		}
		public List<DateTimeOperationContext> dateTimeOperation() {
			return getRuleContexts(DateTimeOperationContext.class);
		}
		public DateTimeOperationContext dateTimeOperation(int i) {
			return getRuleContext(DateTimeOperationContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MathematicalSentenceParserGrammarParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(MathematicalSentenceParserGrammarParser.ENDIF, 0); }
		public TerminalNode ELSEIF() { return getToken(MathematicalSentenceParserGrammarParser.ELSEIF, 0); }
		public DateTimeDecisionExpressionContext(DateTimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateTimeDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateTimeDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateTimeDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeVariableContext extends DateTimeEntityContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode DATETIME_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.DATETIME_TYPE, 0); }
		public DateTimeVariableContext(DateTimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateTimeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateTimeVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateTimeVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeFunctionResultContext extends DateTimeEntityContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode DATETIME_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.DATETIME_TYPE, 0); }
		public DateTimeFunctionResultContext(DateTimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateTimeFunctionResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateTimeFunctionResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateTimeFunctionResult(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateTimeFunctionDecisionExpressionContext extends DateTimeEntityContext {
		public TerminalNode IF() { return getToken(MathematicalSentenceParserGrammarParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public List<DateTimeOperationContext> dateTimeOperation() {
			return getRuleContexts(DateTimeOperationContext.class);
		}
		public DateTimeOperationContext dateTimeOperation(int i) {
			return getRuleContext(DateTimeOperationContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MathematicalSentenceParserGrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.SEMI, i);
		}
		public DateTimeFunctionDecisionExpressionContext(DateTimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateTimeFunctionDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateTimeFunctionDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateTimeFunctionDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateTimeEntityContext dateTimeEntity() throws RecognitionException {
		DateTimeEntityContext _localctx = new DateTimeEntityContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_dateTimeEntity);
		int _la;
		try {
			int _alt;
			setState(579);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				_localctx = new DateTimeDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(535);
				match(IF);
				setState(536);
				logicalExpression(0);
				setState(537);
				match(THEN);
				setState(538);
				dateTimeOperation();
				setState(544);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(539);
					match(ELSEIF);
					setState(540);
					logicalExpression(0);
					setState(541);
					match(THEN);
					setState(542);
					dateTimeOperation();
					}
				}

				setState(546);
				match(ELSE);
				setState(547);
				dateTimeOperation();
				setState(548);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new DateTimeFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(550);
				match(IF);
				setState(551);
				match(LPAREN);
				setState(552);
				logicalExpression(0);
				setState(553);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(554);
				dateTimeOperation();
				setState(562);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(555);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(556);
						logicalExpression(0);
						setState(557);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(558);
						dateTimeOperation();
						}
						} 
					}
					setState(564);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				}
				setState(565);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(566);
				dateTimeOperation();
				setState(567);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new DateTimeConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(569);
				match(DATETIME);
				}
				break;
			case 4:
				_localctx = new DateTimeCurrentValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(570);
				match(NOW_DATETIME);
				}
				break;
			case 5:
				_localctx = new DateTimeVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(572);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATETIME_TYPE) {
					{
					setState(571);
					match(DATETIME_TYPE);
					}
				}

				setState(574);
				match(IDENTIFIER);
				}
				break;
			case 6:
				_localctx = new DateTimeFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(576);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATETIME_TYPE) {
					{
					setState(575);
					match(DATETIME_TYPE);
					}
				}

				setState(578);
				function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VectorEntityContext extends ParserRuleContext {
		public VectorEntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vectorEntity; }
	 
		public VectorEntityContext() { }
		public void copyFrom(VectorEntityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorOfDatesContext extends VectorEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<DateEntityContext> dateEntity() {
			return getRuleContexts(DateEntityContext.class);
		}
		public DateEntityContext dateEntity(int i) {
			return getRuleContext(DateEntityContext.class,i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public VectorOfDatesContext(VectorEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterVectorOfDates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitVectorOfDates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitVectorOfDates(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorOfStringsContext extends VectorEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<StringEntityContext> stringEntity() {
			return getRuleContexts(StringEntityContext.class);
		}
		public StringEntityContext stringEntity(int i) {
			return getRuleContext(StringEntityContext.class,i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public VectorOfStringsContext(VectorEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterVectorOfStrings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitVectorOfStrings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitVectorOfStrings(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorOfNumbersContext extends VectorEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<NumericEntityContext> numericEntity() {
			return getRuleContexts(NumericEntityContext.class);
		}
		public NumericEntityContext numericEntity(int i) {
			return getRuleContext(NumericEntityContext.class,i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public VectorOfNumbersContext(VectorEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterVectorOfNumbers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitVectorOfNumbers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitVectorOfNumbers(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorOfTimesContext extends VectorEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<TimeEntityContext> timeEntity() {
			return getRuleContexts(TimeEntityContext.class);
		}
		public TimeEntityContext timeEntity(int i) {
			return getRuleContext(TimeEntityContext.class,i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public VectorOfTimesContext(VectorEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterVectorOfTimes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitVectorOfTimes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitVectorOfTimes(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorOfDateTimesContext extends VectorEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<DateTimeEntityContext> dateTimeEntity() {
			return getRuleContexts(DateTimeEntityContext.class);
		}
		public DateTimeEntityContext dateTimeEntity(int i) {
			return getRuleContext(DateTimeEntityContext.class,i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public VectorOfDateTimesContext(VectorEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterVectorOfDateTimes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitVectorOfDateTimes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitVectorOfDateTimes(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorVariableContext extends VectorEntityContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode VECTOR_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.VECTOR_TYPE, 0); }
		public VectorVariableContext(VectorEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterVectorVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitVectorVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitVectorVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorOfBooleansContext extends VectorEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<LogicalEntityContext> logicalEntity() {
			return getRuleContexts(LogicalEntityContext.class);
		}
		public LogicalEntityContext logicalEntity(int i) {
			return getRuleContext(LogicalEntityContext.class,i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public VectorOfBooleansContext(VectorEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterVectorOfBooleans(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitVectorOfBooleans(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitVectorOfBooleans(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorEntityContext vectorEntity() throws RecognitionException {
		VectorEntityContext _localctx = new VectorEntityContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_vectorEntity);
		int _la;
		try {
			setState(651);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				_localctx = new VectorOfNumbersContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(581);
				match(LBLACKET);
				setState(582);
				numericEntity();
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(583);
					match(COMMA);
					setState(584);
					numericEntity();
					}
					}
					setState(589);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(590);
				match(RBLACKET);
				}
				break;
			case 2:
				_localctx = new VectorOfBooleansContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(592);
				match(LBLACKET);
				setState(593);
				logicalEntity();
				setState(598);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(594);
					match(COMMA);
					setState(595);
					logicalEntity();
					}
					}
					setState(600);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(601);
				match(RBLACKET);
				}
				break;
			case 3:
				_localctx = new VectorOfStringsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(603);
				match(LBLACKET);
				setState(604);
				stringEntity();
				setState(609);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(605);
					match(COMMA);
					setState(606);
					stringEntity();
					}
					}
					setState(611);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(612);
				match(RBLACKET);
				}
				break;
			case 4:
				_localctx = new VectorOfDatesContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(614);
				match(LBLACKET);
				setState(615);
				dateEntity();
				setState(620);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(616);
					match(COMMA);
					setState(617);
					dateEntity();
					}
					}
					setState(622);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(623);
				match(RBLACKET);
				}
				break;
			case 5:
				_localctx = new VectorOfTimesContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(625);
				match(LBLACKET);
				setState(626);
				timeEntity();
				setState(631);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(627);
					match(COMMA);
					setState(628);
					timeEntity();
					}
					}
					setState(633);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(634);
				match(RBLACKET);
				}
				break;
			case 6:
				_localctx = new VectorOfDateTimesContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(636);
				match(LBLACKET);
				setState(637);
				dateTimeEntity();
				setState(642);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(638);
					match(COMMA);
					setState(639);
					dateTimeEntity();
					}
					}
					setState(644);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(645);
				match(RBLACKET);
				}
				break;
			case 7:
				_localctx = new VectorVariableContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(648);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VECTOR_TYPE) {
					{
					setState(647);
					match(VECTOR_TYPE);
					}
				}

				setState(650);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VectorOfVariablesContext extends ParserRuleContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(MathematicalSentenceParserGrammarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public VectorOfVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vectorOfVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterVectorOfVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitVectorOfVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitVectorOfVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorOfVariablesContext vectorOfVariables() throws RecognitionException {
		VectorOfVariablesContext _localctx = new VectorOfVariablesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_vectorOfVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			match(LBLACKET);
			setState(654);
			match(IDENTIFIER);
			setState(659);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(655);
				match(COMMA);
				setState(656);
				match(IDENTIFIER);
				}
				}
				setState(661);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(662);
			match(RBLACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return logicalExpression_sempred((LogicalExpressionContext)_localctx, predIndex);
		case 5:
			return mathExpression_sempred((MathExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logicalExpression_sempred(LogicalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		}
		return true;
	}
	private boolean mathExpression_sempred(MathExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001f\u0299\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0003\u00005\b\u0000\u0001\u0001\u0005\u0001"+
		"8\b\u0001\n\u0001\f\u0001;\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0005\u0002A\b\u0002\n\u0002\f\u0002D\t\u0002\u0001\u0002"+
		"\u0003\u0002G\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003T\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"X\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"v\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"|\b\u0004\n\u0004\f\u0004\u007f\t\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0099\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005\u00ad\b\u0005\n\u0005\f\u0005\u00b0\t\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u00b5\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00c3\b\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00dc\b\n\n\n\f\n\u00df\t\n"+
		"\u0003\n\u00e1\b\n\u0003\n\u00e3\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u00ee\b\u000b\n\u000b\f\u000b\u00f1\t\u000b\u0003\u000b\u00f3"+
		"\b\u000b\u0003\u000b\u00f5\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0100\b\f\n\f\f\f\u0103\t\f"+
		"\u0003\f\u0105\b\f\u0003\f\u0107\b\f\u0001\r\u0003\r\u010a\b\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0111\b\r\n\r\f\r\u0114\t\r\u0005"+
		"\r\u0116\b\r\n\r\f\r\u0119\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0123\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u012c\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u0138\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u0148\b\u0011\n\u0011\f\u0011\u014b\t\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0152\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u0156\b\u0011\u0001\u0011\u0003\u0011\u0159\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0164\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u0174\b\u0012\n\u0012\f\u0012\u0177\t\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0183\b\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u0187\b\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u018b\b\u0012\u0003\u0012\u018d\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u0198\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013"+
		"\u01a8\b\u0013\n\u0013\f\u0013\u01ab\t\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u01b3\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u01b7\b\u0013\u0001\u0013\u0003\u0013\u01ba"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u01c5\b\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u01d5\b\u0014\n\u0014\f\u0014\u01d8\t\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u01e1\b\u0014\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u01e5\b\u0014\u0001\u0014\u0003\u0014\u01e8\b\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u01f3\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005"+
		"\u0015\u0203\b\u0015\n\u0015\f\u0015\u0206\t\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u020f\b\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0213\b\u0015\u0001"+
		"\u0015\u0003\u0015\u0216\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u0221\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0231\b\u0016\n"+
		"\u0016\f\u0016\u0234\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u023d\b\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u0241\b\u0016\u0001\u0016\u0003\u0016\u0244"+
		"\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u024a"+
		"\b\u0017\n\u0017\f\u0017\u024d\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0255\b\u0017\n\u0017"+
		"\f\u0017\u0258\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u0260\b\u0017\n\u0017\f\u0017\u0263"+
		"\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u026b\b\u0017\n\u0017\f\u0017\u026e\t\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u0276\b\u0017\n\u0017\f\u0017\u0279\t\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0281\b\u0017\n"+
		"\u0017\f\u0017\u0284\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u0289\b\u0017\u0001\u0017\u0003\u0017\u028c\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0292\b\u0018\n\u0018"+
		"\f\u0018\u0295\t\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0000\u0002"+
		"\b\n\u0019\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.0\u0000\f\u0002\u0000\u0015\u0015++\u0002"+
		"\u0000\u000e\u000f\u0013\u0013\u0001\u0000\u0010\u0011\u0001\u0000\u0019"+
		"\u001b\u0001\u0000,3\u0001\u0000\u001d\u001e\u0001\u000045\u0001\u0000"+
		"QR\u0001\u0000%*\u0001\u0000\b\u000b\u0001\u0000)*\u0001\u0000\f\r\u02f8"+
		"\u00004\u0001\u0000\u0000\u0000\u00029\u0001\u0000\u0000\u0000\u0004B"+
		"\u0001\u0000\u0000\u0000\u0006W\u0001\u0000\u0000\u0000\bu\u0001\u0000"+
		"\u0000\u0000\n\u0098\u0001\u0000\u0000\u0000\f\u00b4\u0001\u0000\u0000"+
		"\u0000\u000e\u00c2\u0001\u0000\u0000\u0000\u0010\u00c4\u0001\u0000\u0000"+
		"\u0000\u0012\u00cb\u0001\u0000\u0000\u0000\u0014\u00e2\u0001\u0000\u0000"+
		"\u0000\u0016\u00f4\u0001\u0000\u0000\u0000\u0018\u0106\u0001\u0000\u0000"+
		"\u0000\u001a\u0109\u0001\u0000\u0000\u0000\u001c\u011c\u0001\u0000\u0000"+
		"\u0000\u001e\u0122\u0001\u0000\u0000\u0000 \u012b\u0001\u0000\u0000\u0000"+
		"\"\u0158\u0001\u0000\u0000\u0000$\u018c\u0001\u0000\u0000\u0000&\u01b9"+
		"\u0001\u0000\u0000\u0000(\u01e7\u0001\u0000\u0000\u0000*\u0215\u0001\u0000"+
		"\u0000\u0000,\u0243\u0001\u0000\u0000\u0000.\u028b\u0001\u0000\u0000\u0000"+
		"0\u028d\u0001\u0000\u0000\u000025\u0003\u0002\u0001\u000035\u0003\u0004"+
		"\u0002\u000042\u0001\u0000\u0000\u000043\u0001\u0000\u0000\u00005\u0001"+
		"\u0001\u0000\u0000\u000068\u0003\u0006\u0003\u000076\u0001\u0000\u0000"+
		"\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0003"+
		"\n\u0005\u0000=>\u0005\u0000\u0000\u0001>\u0003\u0001\u0000\u0000\u0000"+
		"?A\u0003\u0006\u0003\u0000@?\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000"+
		"\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CF\u0001\u0000"+
		"\u0000\u0000DB\u0001\u0000\u0000\u0000EG\u0003\b\u0004\u0000FE\u0001\u0000"+
		"\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0005"+
		"\u0000\u0000\u0001I\u0005\u0001\u0000\u0000\u0000JK\u0005V\u0000\u0000"+
		"KL\u0005)\u0000\u0000LM\u0003 \u0010\u0000MN\u0005R\u0000\u0000NX\u0001"+
		"\u0000\u0000\u0000OP\u00030\u0018\u0000PS\u0005)\u0000\u0000QT\u0003."+
		"\u0017\u0000RT\u0003\u001a\r\u0000SQ\u0001\u0000\u0000\u0000SR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0005R\u0000\u0000VX\u0001\u0000"+
		"\u0000\u0000WJ\u0001\u0000\u0000\u0000WO\u0001\u0000\u0000\u0000X\u0007"+
		"\u0001\u0000\u0000\u0000YZ\u0006\u0004\uffff\uffff\u0000Z[\u0007\u0000"+
		"\u0000\u0000[v\u0003\b\u0004\t\\]\u0003\n\u0005\u0000]^\u0003\u001c\u000e"+
		"\u0000^_\u0003\n\u0005\u0000_v\u0001\u0000\u0000\u0000`a\u0003&\u0013"+
		"\u0000ab\u0003\u001c\u000e\u0000bc\u0003&\u0013\u0000cv\u0001\u0000\u0000"+
		"\u0000de\u0003\u0014\n\u0000ef\u0003\u001c\u000e\u0000fg\u0003\u0014\n"+
		"\u0000gv\u0001\u0000\u0000\u0000hi\u0003\u0016\u000b\u0000ij\u0003\u001c"+
		"\u000e\u0000jk\u0003\u0016\u000b\u0000kv\u0001\u0000\u0000\u0000lm\u0003"+
		"\u0018\f\u0000mn\u0003\u001c\u000e\u0000no\u0003\u0018\f\u0000ov\u0001"+
		"\u0000\u0000\u0000pq\u0005K\u0000\u0000qr\u0003\b\u0004\u0000rs\u0005"+
		"L\u0000\u0000sv\u0001\u0000\u0000\u0000tv\u0003\"\u0011\u0000uY\u0001"+
		"\u0000\u0000\u0000u\\\u0001\u0000\u0000\u0000u`\u0001\u0000\u0000\u0000"+
		"ud\u0001\u0000\u0000\u0000uh\u0001\u0000\u0000\u0000ul\u0001\u0000\u0000"+
		"\u0000up\u0001\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000v}\u0001\u0000"+
		"\u0000\u0000wx\n\b\u0000\u0000xy\u0003\u001e\u000f\u0000yz\u0003\b\u0004"+
		"\tz|\u0001\u0000\u0000\u0000{w\u0001\u0000\u0000\u0000|\u007f\u0001\u0000"+
		"\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\t\u0001"+
		"\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0006\u0005"+
		"\uffff\uffff\u0000\u0081\u0082\u0005K\u0000\u0000\u0082\u0083\u0003\n"+
		"\u0005\u0000\u0083\u0084\u0005L\u0000\u0000\u0084\u0099\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0005!\u0000\u0000\u0086\u0087\u0003\n\u0005\u0000"+
		"\u0087\u0088\u0005L\u0000\u0000\u0088\u0099\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0005\u0018\u0000\u0000\u008a\u008b\u0005K\u0000\u0000\u008b\u008c"+
		"\u0003\n\u0005\u0000\u008c\u008d\u0005L\u0000\u0000\u008d\u0099\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0003(\u0014\u0000\u008f\u0090\u0005\u0011"+
		"\u0000\u0000\u0090\u0091\u0003(\u0014\u0000\u0091\u0099\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0005\u0014\u0000\u0000\u0093\u0094\u0003\n\u0005\u0000"+
		"\u0094\u0095\u0005\u0014\u0000\u0000\u0095\u0099\u0001\u0000\u0000\u0000"+
		"\u0096\u0099\u0003\f\u0006\u0000\u0097\u0099\u0003$\u0012\u0000\u0098"+
		"\u0080\u0001\u0000\u0000\u0000\u0098\u0085\u0001\u0000\u0000\u0000\u0098"+
		"\u0089\u0001\u0000\u0000\u0000\u0098\u008e\u0001\u0000\u0000\u0000\u0098"+
		"\u0092\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098"+
		"\u0097\u0001\u0000\u0000\u0000\u0099\u00ae\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\n\n\u0000\u0000\u009b\u009c\u0005\u0017\u0000\u0000\u009c\u00ad"+
		"\u0003\n\u0005\u000b\u009d\u009e\n\b\u0000\u0000\u009e\u009f\u0005\u0016"+
		"\u0000\u0000\u009f\u00ad\u0003\n\u0005\b\u00a0\u00a1\n\u0007\u0000\u0000"+
		"\u00a1\u00a2\u0007\u0001\u0000\u0000\u00a2\u00ad\u0003\n\u0005\b\u00a3"+
		"\u00a4\n\u0006\u0000\u0000\u00a4\u00a5\u0007\u0002\u0000\u0000\u00a5\u00ad"+
		"\u0003\n\u0005\u0007\u00a6\u00a7\n\f\u0000\u0000\u00a7\u00ad\u0005\u0012"+
		"\u0000\u0000\u00a8\u00a9\n\u000b\u0000\u0000\u00a9\u00ad\u0005\u0015\u0000"+
		"\u0000\u00aa\u00ab\n\u0003\u0000\u0000\u00ab\u00ad\u0005$\u0000\u0000"+
		"\u00ac\u009a\u0001\u0000\u0000\u0000\u00ac\u009d\u0001\u0000\u0000\u0000"+
		"\u00ac\u00a0\u0001\u0000\u0000\u0000\u00ac\u00a3\u0001\u0000\u0000\u0000"+
		"\u00ac\u00a6\u0001\u0000\u0000\u0000\u00ac\u00a8\u0001\u0000\u0000\u0000"+
		"\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000"+
		"\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000"+
		"\u00af\u000b\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b5\u0003\u000e\u0007\u0000\u00b2\u00b5\u0003\u0010\b\u0000\u00b3"+
		"\u00b5\u0003\u0012\t\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\r\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0007\u0003\u0000\u0000\u00b7\u00b8\u0005"+
		"K\u0000\u0000\u00b8\u00b9\u0003\n\u0005\u0000\u00b9\u00ba\u0005L\u0000"+
		"\u0000\u00ba\u00c3\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u001c\u0000"+
		"\u0000\u00bc\u00bd\u0005K\u0000\u0000\u00bd\u00be\u0003\n\u0005\u0000"+
		"\u00be\u00bf\u0005Q\u0000\u0000\u00bf\u00c0\u0003\n\u0005\u0000\u00c0"+
		"\u00c1\u0005L\u0000\u0000\u00c1\u00c3\u0001\u0000\u0000\u0000\u00c2\u00b6"+
		"\u0001\u0000\u0000\u0000\u00c2\u00bb\u0001\u0000\u0000\u0000\u00c3\u000f"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0007\u0004\u0000\u0000\u00c5\u00c6"+
		"\u0005K\u0000\u0000\u00c6\u00c7\u0003\n\u0005\u0000\u00c7\u00c8\u0005"+
		"Q\u0000\u0000\u00c8\u00c9\u0003\n\u0005\u0000\u00c9\u00ca\u0005L\u0000"+
		"\u0000\u00ca\u0011\u0001\u0000\u0000\u0000\u00cb\u00cc\u0007\u0005\u0000"+
		"\u0000\u00cc\u00cd\u0003.\u0017\u0000\u00cd\u00ce\u0005N\u0000\u0000\u00ce"+
		"\u00cf\u0005K\u0000\u0000\u00cf\u00d0\u0003\n\u0005\u0000\u00d0\u00d1"+
		"\u0005L\u0000\u0000\u00d1\u0013\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005"+
		"K\u0000\u0000\u00d3\u00d4\u0003\u0014\n\u0000\u00d4\u00d5\u0005L\u0000"+
		"\u0000\u00d5\u00e3\u0001\u0000\u0000\u0000\u00d6\u00e0\u0003(\u0014\u0000"+
		"\u00d7\u00d8\u00054\u0000\u0000\u00d8\u00dd\u0003\n\u0005\u0000\u00d9"+
		"\u00da\u00054\u0000\u0000\u00da\u00dc\u0003\n\u0005\u0000\u00db\u00d9"+
		"\u0001\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd\u00db"+
		"\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00e1"+
		"\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00d7"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e2\u00d2\u0001\u0000\u0000\u0000\u00e2\u00d6"+
		"\u0001\u0000\u0000\u0000\u00e3\u0015\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0005K\u0000\u0000\u00e5\u00e6\u0003\u0016\u000b\u0000\u00e6\u00e7\u0005"+
		"L\u0000\u0000\u00e7\u00f5\u0001\u0000\u0000\u0000\u00e8\u00f2\u0003*\u0015"+
		"\u0000\u00e9\u00ea\u00055\u0000\u0000\u00ea\u00ef\u0003\n\u0005\u0000"+
		"\u00eb\u00ec\u00055\u0000\u0000\u00ec\u00ee\u0003\n\u0005\u0000\u00ed"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef"+
		"\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2"+
		"\u00e9\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f4\u00e4\u0001\u0000\u0000\u0000\u00f4"+
		"\u00e8\u0001\u0000\u0000\u0000\u00f5\u0017\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f7\u0005K\u0000\u0000\u00f7\u00f8\u0003\u0018\f\u0000\u00f8\u00f9"+
		"\u0005L\u0000\u0000\u00f9\u0107\u0001\u0000\u0000\u0000\u00fa\u0104\u0003"+
		",\u0016\u0000\u00fb\u00fc\u0007\u0006\u0000\u0000\u00fc\u0101\u0003\n"+
		"\u0005\u0000\u00fd\u00fe\u0007\u0006\u0000\u0000\u00fe\u0100\u0003\n\u0005"+
		"\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000"+
		"\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000"+
		"\u0000\u0102\u0105\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000"+
		"\u0000\u0104\u00fb\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000"+
		"\u0000\u0105\u0107\u0001\u0000\u0000\u0000\u0106\u00f6\u0001\u0000\u0000"+
		"\u0000\u0106\u00fa\u0001\u0000\u0000\u0000\u0107\u0019\u0001\u0000\u0000"+
		"\u0000\u0108\u010a\u0005U\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000"+
		"\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0005V\u0000\u0000\u010c\u0117\u0005K\u0000\u0000\u010d\u0112"+
		"\u0003 \u0010\u0000\u010e\u010f\u0007\u0007\u0000\u0000\u010f\u0111\u0003"+
		" \u0010\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0114\u0001\u0000"+
		"\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000"+
		"\u0000\u0000\u0113\u0116\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000"+
		"\u0000\u0000\u0115\u010d\u0001\u0000\u0000\u0000\u0116\u0119\u0001\u0000"+
		"\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000"+
		"\u0000\u0000\u0118\u011a\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000"+
		"\u0000\u0000\u011a\u011b\u0005L\u0000\u0000\u011b\u001b\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0007\b\u0000\u0000\u011d\u001d\u0001\u0000\u0000\u0000"+
		"\u011e\u0123\u0005\u0006\u0000\u0000\u011f\u0123\u0005\u0007\u0000\u0000"+
		"\u0120\u0123\u0007\t\u0000\u0000\u0121\u0123\u0007\n\u0000\u0000\u0122"+
		"\u011e\u0001\u0000\u0000\u0000\u0122\u011f\u0001\u0000\u0000\u0000\u0122"+
		"\u0120\u0001\u0000\u0000\u0000\u0122\u0121\u0001\u0000\u0000\u0000\u0123"+
		"\u001f\u0001\u0000\u0000\u0000\u0124\u012c\u0003\n\u0005\u0000\u0125\u012c"+
		"\u0003\b\u0004\u0000\u0126\u012c\u0003\u0014\n\u0000\u0127\u012c\u0003"+
		"\u0016\u000b\u0000\u0128\u012c\u0003\u0018\f\u0000\u0129\u012c\u0003&"+
		"\u0013\u0000\u012a\u012c\u0003.\u0017\u0000\u012b\u0124\u0001\u0000\u0000"+
		"\u0000\u012b\u0125\u0001\u0000\u0000\u0000\u012b\u0126\u0001\u0000\u0000"+
		"\u0000\u012b\u0127\u0001\u0000\u0000\u0000\u012b\u0128\u0001\u0000\u0000"+
		"\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012a\u0001\u0000\u0000"+
		"\u0000\u012c!\u0001\u0000\u0000\u0000\u012d\u0159\u0007\u000b\u0000\u0000"+
		"\u012e\u012f\u0005\u0001\u0000\u0000\u012f\u0130\u0003\b\u0004\u0000\u0130"+
		"\u0131\u0005\u0002\u0000\u0000\u0131\u0137\u0003\b\u0004\u0000\u0132\u0133"+
		"\u0005\u0004\u0000\u0000\u0133\u0134\u0003\b\u0004\u0000\u0134\u0135\u0005"+
		"\u0002\u0000\u0000\u0135\u0136\u0003\b\u0004\u0000\u0136\u0138\u0001\u0000"+
		"\u0000\u0000\u0137\u0132\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000"+
		"\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013a\u0005\u0003"+
		"\u0000\u0000\u013a\u013b\u0003\b\u0004\u0000\u013b\u013c\u0005\u0005\u0000"+
		"\u0000\u013c\u0159\u0001\u0000\u0000\u0000\u013d\u013e\u0005\u0001\u0000"+
		"\u0000\u013e\u013f\u0005K\u0000\u0000\u013f\u0140\u0003\b\u0004\u0000"+
		"\u0140\u0141\u0007\u0007\u0000\u0000\u0141\u0149\u0003\b\u0004\u0000\u0142"+
		"\u0143\u0007\u0007\u0000\u0000\u0143\u0144\u0003\b\u0004\u0000\u0144\u0145"+
		"\u0007\u0007\u0000\u0000\u0145\u0146\u0003\b\u0004\u0000\u0146\u0148\u0001"+
		"\u0000\u0000\u0000\u0147\u0142\u0001\u0000\u0000\u0000\u0148\u014b\u0001"+
		"\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001"+
		"\u0000\u0000\u0000\u014a\u014c\u0001\u0000\u0000\u0000\u014b\u0149\u0001"+
		"\u0000\u0000\u0000\u014c\u014d\u0007\u0007\u0000\u0000\u014d\u014e\u0003"+
		"\b\u0004\u0000\u014e\u014f\u0005L\u0000\u0000\u014f\u0159\u0001\u0000"+
		"\u0000\u0000\u0150\u0152\u0005^\u0000\u0000\u0151\u0150\u0001\u0000\u0000"+
		"\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000"+
		"\u0000\u0153\u0159\u0003\u001a\r\u0000\u0154\u0156\u0005^\u0000\u0000"+
		"\u0155\u0154\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u0001\u0000\u0000\u0000\u0157\u0159\u0005V\u0000\u0000\u0158"+
		"\u012d\u0001\u0000\u0000\u0000\u0158\u012e\u0001\u0000\u0000\u0000\u0158"+
		"\u013d\u0001\u0000\u0000\u0000\u0158\u0151\u0001\u0000\u0000\u0000\u0158"+
		"\u0155\u0001\u0000\u0000\u0000\u0159#\u0001\u0000\u0000\u0000\u015a\u015b"+
		"\u0005\u0001\u0000\u0000\u015b\u015c\u0003\b\u0004\u0000\u015c\u015d\u0005"+
		"\u0002\u0000\u0000\u015d\u0163\u0003\n\u0005\u0000\u015e\u015f\u0005\u0004"+
		"\u0000\u0000\u015f\u0160\u0003\b\u0004\u0000\u0160\u0161\u0005\u0002\u0000"+
		"\u0000\u0161\u0162\u0003\n\u0005\u0000\u0162\u0164\u0001\u0000\u0000\u0000"+
		"\u0163\u015e\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000"+
		"\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0166\u0005\u0003\u0000\u0000"+
		"\u0166\u0167\u0003\n\u0005\u0000\u0167\u0168\u0005\u0005\u0000\u0000\u0168"+
		"\u018d\u0001\u0000\u0000\u0000\u0169\u016a\u0005\u0001\u0000\u0000\u016a"+
		"\u016b\u0005K\u0000\u0000\u016b\u016c\u0003\b\u0004\u0000\u016c\u016d"+
		"\u0007\u0007\u0000\u0000\u016d\u0175\u0003\n\u0005\u0000\u016e\u016f\u0007"+
		"\u0007\u0000\u0000\u016f\u0170\u0003\b\u0004\u0000\u0170\u0171\u0007\u0007"+
		"\u0000\u0000\u0171\u0172\u0003\n\u0005\u0000\u0172\u0174\u0001\u0000\u0000"+
		"\u0000\u0173\u016e\u0001\u0000\u0000\u0000\u0174\u0177\u0001\u0000\u0000"+
		"\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000"+
		"\u0000\u0176\u0178\u0001\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000"+
		"\u0000\u0178\u0179\u0007\u0007\u0000\u0000\u0179\u017a\u0003\n\u0005\u0000"+
		"\u017a\u017b\u0005L\u0000\u0000\u017b\u018d\u0001\u0000\u0000\u0000\u017c"+
		"\u018d\u0005#\u0000\u0000\u017d\u018d\u0005\"\u0000\u0000\u017e\u018d"+
		"\u0005\u001f\u0000\u0000\u017f\u018d\u0005 \u0000\u0000\u0180\u018d\u0005"+
		"Y\u0000\u0000\u0181\u0183\u0005_\u0000\u0000\u0182\u0181\u0001\u0000\u0000"+
		"\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000"+
		"\u0000\u0184\u018d\u0003\u001a\r\u0000\u0185\u0187\u0005_\u0000\u0000"+
		"\u0186\u0185\u0001\u0000\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000"+
		"\u0187\u0188\u0001\u0000\u0000\u0000\u0188\u018b\u0005V\u0000\u0000\u0189"+
		"\u018b\u0005W\u0000\u0000\u018a\u0186\u0001\u0000\u0000\u0000\u018a\u0189"+
		"\u0001\u0000\u0000\u0000\u018b\u018d\u0001\u0000\u0000\u0000\u018c\u015a"+
		"\u0001\u0000\u0000\u0000\u018c\u0169\u0001\u0000\u0000\u0000\u018c\u017c"+
		"\u0001\u0000\u0000\u0000\u018c\u017d\u0001\u0000\u0000\u0000\u018c\u017e"+
		"\u0001\u0000\u0000\u0000\u018c\u017f\u0001\u0000\u0000\u0000\u018c\u0180"+
		"\u0001\u0000\u0000\u0000\u018c\u0182\u0001\u0000\u0000\u0000\u018c\u018a"+
		"\u0001\u0000\u0000\u0000\u018d%\u0001\u0000\u0000\u0000\u018e\u018f\u0005"+
		"\u0001\u0000\u0000\u018f\u0190\u0003\b\u0004\u0000\u0190\u0191\u0005\u0002"+
		"\u0000\u0000\u0191\u0197\u0003&\u0013\u0000\u0192\u0193\u0005\u0004\u0000"+
		"\u0000\u0193\u0194\u0003\b\u0004\u0000\u0194\u0195\u0005\u0002\u0000\u0000"+
		"\u0195\u0196\u0003&\u0013\u0000\u0196\u0198\u0001\u0000\u0000\u0000\u0197"+
		"\u0192\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000\u0198"+
		"\u0199\u0001\u0000\u0000\u0000\u0199\u019a\u0005\u0003\u0000\u0000\u019a"+
		"\u019b\u0003&\u0013\u0000\u019b\u019c\u0005\u0005\u0000\u0000\u019c\u01ba"+
		"\u0001\u0000\u0000\u0000\u019d\u019e\u0005\u0001\u0000\u0000\u019e\u019f"+
		"\u0005K\u0000\u0000\u019f\u01a0\u0003\b\u0004\u0000\u01a0\u01a1\u0007"+
		"\u0007\u0000\u0000\u01a1\u01a9\u0003&\u0013\u0000\u01a2\u01a3\u0007\u0007"+
		"\u0000\u0000\u01a3\u01a4\u0003\b\u0004\u0000\u01a4\u01a5\u0007\u0007\u0000"+
		"\u0000\u01a5\u01a6\u0003&\u0013\u0000\u01a6\u01a8\u0001\u0000\u0000\u0000"+
		"\u01a7\u01a2\u0001\u0000\u0000\u0000\u01a8\u01ab\u0001\u0000\u0000\u0000"+
		"\u01a9\u01a7\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000"+
		"\u01aa\u01ac\u0001\u0000\u0000\u0000\u01ab\u01a9\u0001\u0000\u0000\u0000"+
		"\u01ac\u01ad\u0007\u0007\u0000\u0000\u01ad\u01ae\u0003&\u0013\u0000\u01ae"+
		"\u01af\u0005L\u0000\u0000\u01af\u01ba\u0001\u0000\u0000\u0000\u01b0\u01ba"+
		"\u0005X\u0000\u0000\u01b1\u01b3\u0005`\u0000\u0000\u01b2\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000"+
		"\u0000\u0000\u01b4\u01ba\u0003\u001a\r\u0000\u01b5\u01b7\u0005`\u0000"+
		"\u0000\u01b6\u01b5\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000\u0000"+
		"\u0000\u01b7\u01b8\u0001\u0000\u0000\u0000\u01b8\u01ba\u0005V\u0000\u0000"+
		"\u01b9\u018e\u0001\u0000\u0000\u0000\u01b9\u019d\u0001\u0000\u0000\u0000"+
		"\u01b9\u01b0\u0001\u0000\u0000\u0000\u01b9\u01b2\u0001\u0000\u0000\u0000"+
		"\u01b9\u01b6\u0001\u0000\u0000\u0000\u01ba\'\u0001\u0000\u0000\u0000\u01bb"+
		"\u01bc\u0005\u0001\u0000\u0000\u01bc\u01bd\u0003\b\u0004\u0000\u01bd\u01be"+
		"\u0005\u0002\u0000\u0000\u01be\u01c4\u0003\u0014\n\u0000\u01bf\u01c0\u0005"+
		"\u0004\u0000\u0000\u01c0\u01c1\u0003\b\u0004\u0000\u01c1\u01c2\u0005\u0002"+
		"\u0000\u0000\u01c2\u01c3\u0003\u0014\n\u0000\u01c3\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c4\u01bf\u0001\u0000\u0000\u0000\u01c4\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005\u0003\u0000"+
		"\u0000\u01c7\u01c8\u0003\u0014\n\u0000\u01c8\u01c9\u0005\u0005\u0000\u0000"+
		"\u01c9\u01e8\u0001\u0000\u0000\u0000\u01ca\u01cb\u0005\u0001\u0000\u0000"+
		"\u01cb\u01cc\u0005K\u0000\u0000\u01cc\u01cd\u0003\b\u0004\u0000\u01cd"+
		"\u01ce\u0007\u0007\u0000\u0000\u01ce\u01d6\u0003\u0014\n\u0000\u01cf\u01d0"+
		"\u0007\u0007\u0000\u0000\u01d0\u01d1\u0003\b\u0004\u0000\u01d1\u01d2\u0007"+
		"\u0007\u0000\u0000\u01d2\u01d3\u0003\u0014\n\u0000\u01d3\u01d5\u0001\u0000"+
		"\u0000\u0000\u01d4\u01cf\u0001\u0000\u0000\u0000\u01d5\u01d8\u0001\u0000"+
		"\u0000\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d7\u01d9\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000"+
		"\u0000\u0000\u01d9\u01da\u0007\u0007\u0000\u0000\u01da\u01db\u0003\u0014"+
		"\n\u0000\u01db\u01dc\u0005L\u0000\u0000\u01dc\u01e8\u0001\u0000\u0000"+
		"\u0000\u01dd\u01e8\u0005[\u0000\u0000\u01de\u01e8\u00056\u0000\u0000\u01df"+
		"\u01e1\u0005a\u0000\u0000\u01e0\u01df\u0001\u0000\u0000\u0000\u01e0\u01e1"+
		"\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2\u01e8"+
		"\u0005V\u0000\u0000\u01e3\u01e5\u0005a\u0000\u0000\u01e4\u01e3\u0001\u0000"+
		"\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000"+
		"\u0000\u0000\u01e6\u01e8\u0003\u001a\r\u0000\u01e7\u01bb\u0001\u0000\u0000"+
		"\u0000\u01e7\u01ca\u0001\u0000\u0000\u0000\u01e7\u01dd\u0001\u0000\u0000"+
		"\u0000\u01e7\u01de\u0001\u0000\u0000\u0000\u01e7\u01e0\u0001\u0000\u0000"+
		"\u0000\u01e7\u01e4\u0001\u0000\u0000\u0000\u01e8)\u0001\u0000\u0000\u0000"+
		"\u01e9\u01ea\u0005\u0001\u0000\u0000\u01ea\u01eb\u0003\b\u0004\u0000\u01eb"+
		"\u01ec\u0005\u0002\u0000\u0000\u01ec\u01f2\u0003\u0016\u000b\u0000\u01ed"+
		"\u01ee\u0005\u0004\u0000\u0000\u01ee\u01ef\u0003\b\u0004\u0000\u01ef\u01f0"+
		"\u0005\u0002\u0000\u0000\u01f0\u01f1\u0003\u0016\u000b\u0000\u01f1\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f2\u01ed\u0001\u0000\u0000\u0000\u01f2\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001\u0000\u0000\u0000\u01f4\u01f5"+
		"\u0005\u0003\u0000\u0000\u01f5\u01f6\u0003\u0016\u000b\u0000\u01f6\u01f7"+
		"\u0005\u0005\u0000\u0000\u01f7\u0216\u0001\u0000\u0000\u0000\u01f8\u01f9"+
		"\u0005\u0001\u0000\u0000\u01f9\u01fa\u0005K\u0000\u0000\u01fa\u01fb\u0003"+
		"\b\u0004\u0000\u01fb\u01fc\u0007\u0007\u0000\u0000\u01fc\u0204\u0003\u0016"+
		"\u000b\u0000\u01fd\u01fe\u0007\u0007\u0000\u0000\u01fe\u01ff\u0003\b\u0004"+
		"\u0000\u01ff\u0200\u0007\u0007\u0000\u0000\u0200\u0201\u0003\u0016\u000b"+
		"\u0000\u0201\u0203\u0001\u0000\u0000\u0000\u0202\u01fd\u0001\u0000\u0000"+
		"\u0000\u0203\u0206\u0001\u0000\u0000\u0000\u0204\u0202\u0001\u0000\u0000"+
		"\u0000\u0204\u0205\u0001\u0000\u0000\u0000\u0205\u0207\u0001\u0000\u0000"+
		"\u0000\u0206\u0204\u0001\u0000\u0000\u0000\u0207\u0208\u0007\u0007\u0000"+
		"\u0000\u0208\u0209\u0003\u0016\u000b\u0000\u0209\u020a\u0005L\u0000\u0000"+
		"\u020a\u0216\u0001\u0000\u0000\u0000\u020b\u0216\u0005\\\u0000\u0000\u020c"+
		"\u0216\u00057\u0000\u0000\u020d\u020f\u0005b\u0000\u0000\u020e\u020d\u0001"+
		"\u0000\u0000\u0000\u020e\u020f\u0001\u0000\u0000\u0000\u020f\u0210\u0001"+
		"\u0000\u0000\u0000\u0210\u0216\u0005V\u0000\u0000\u0211\u0213\u0005b\u0000"+
		"\u0000\u0212\u0211\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000\u0000"+
		"\u0000\u0213\u0214\u0001\u0000\u0000\u0000\u0214\u0216\u0003\u001a\r\u0000"+
		"\u0215\u01e9\u0001\u0000\u0000\u0000\u0215\u01f8\u0001\u0000\u0000\u0000"+
		"\u0215\u020b\u0001\u0000\u0000\u0000\u0215\u020c\u0001\u0000\u0000\u0000"+
		"\u0215\u020e\u0001\u0000\u0000\u0000\u0215\u0212\u0001\u0000\u0000\u0000"+
		"\u0216+\u0001\u0000\u0000\u0000\u0217\u0218\u0005\u0001\u0000\u0000\u0218"+
		"\u0219\u0003\b\u0004\u0000\u0219\u021a\u0005\u0002\u0000\u0000\u021a\u0220"+
		"\u0003\u0018\f\u0000\u021b\u021c\u0005\u0004\u0000\u0000\u021c\u021d\u0003"+
		"\b\u0004\u0000\u021d\u021e\u0005\u0002\u0000\u0000\u021e\u021f\u0003\u0018"+
		"\f\u0000\u021f\u0221\u0001\u0000\u0000\u0000\u0220\u021b\u0001\u0000\u0000"+
		"\u0000\u0220\u0221\u0001\u0000\u0000\u0000\u0221\u0222\u0001\u0000\u0000"+
		"\u0000\u0222\u0223\u0005\u0003\u0000\u0000\u0223\u0224\u0003\u0018\f\u0000"+
		"\u0224\u0225\u0005\u0005\u0000\u0000\u0225\u0244\u0001\u0000\u0000\u0000"+
		"\u0226\u0227\u0005\u0001\u0000\u0000\u0227\u0228\u0005K\u0000\u0000\u0228"+
		"\u0229\u0003\b\u0004\u0000\u0229\u022a\u0007\u0007\u0000\u0000\u022a\u0232"+
		"\u0003\u0018\f\u0000\u022b\u022c\u0007\u0007\u0000\u0000\u022c\u022d\u0003"+
		"\b\u0004\u0000\u022d\u022e\u0007\u0007\u0000\u0000\u022e\u022f\u0003\u0018"+
		"\f\u0000\u022f\u0231\u0001\u0000\u0000\u0000\u0230\u022b\u0001\u0000\u0000"+
		"\u0000\u0231\u0234\u0001\u0000\u0000\u0000\u0232\u0230\u0001\u0000\u0000"+
		"\u0000\u0232\u0233\u0001\u0000\u0000\u0000\u0233\u0235\u0001\u0000\u0000"+
		"\u0000\u0234\u0232\u0001\u0000\u0000\u0000\u0235\u0236\u0007\u0007\u0000"+
		"\u0000\u0236\u0237\u0003\u0018\f\u0000\u0237\u0238\u0005L\u0000\u0000"+
		"\u0238\u0244\u0001\u0000\u0000\u0000\u0239\u0244\u0005]\u0000\u0000\u023a"+
		"\u0244\u00058\u0000\u0000\u023b\u023d\u0005c\u0000\u0000\u023c\u023b\u0001"+
		"\u0000\u0000\u0000\u023c\u023d\u0001\u0000\u0000\u0000\u023d\u023e\u0001"+
		"\u0000\u0000\u0000\u023e\u0244\u0005V\u0000\u0000\u023f\u0241\u0005c\u0000"+
		"\u0000\u0240\u023f\u0001\u0000\u0000\u0000\u0240\u0241\u0001\u0000\u0000"+
		"\u0000\u0241\u0242\u0001\u0000\u0000\u0000\u0242\u0244\u0003\u001a\r\u0000"+
		"\u0243\u0217\u0001\u0000\u0000\u0000\u0243\u0226\u0001\u0000\u0000\u0000"+
		"\u0243\u0239\u0001\u0000\u0000\u0000\u0243\u023a\u0001\u0000\u0000\u0000"+
		"\u0243\u023c\u0001\u0000\u0000\u0000\u0243\u0240\u0001\u0000\u0000\u0000"+
		"\u0244-\u0001\u0000\u0000\u0000\u0245\u0246\u0005M\u0000\u0000\u0246\u024b"+
		"\u0003$\u0012\u0000\u0247\u0248\u0005Q\u0000\u0000\u0248\u024a\u0003$"+
		"\u0012\u0000\u0249\u0247\u0001\u0000\u0000\u0000\u024a\u024d\u0001\u0000"+
		"\u0000\u0000\u024b\u0249\u0001\u0000\u0000\u0000\u024b\u024c\u0001\u0000"+
		"\u0000\u0000\u024c\u024e\u0001\u0000\u0000\u0000\u024d\u024b\u0001\u0000"+
		"\u0000\u0000\u024e\u024f\u0005N\u0000\u0000\u024f\u028c\u0001\u0000\u0000"+
		"\u0000\u0250\u0251\u0005M\u0000\u0000\u0251\u0256\u0003\"\u0011\u0000"+
		"\u0252\u0253\u0005Q\u0000\u0000\u0253\u0255\u0003\"\u0011\u0000\u0254"+
		"\u0252\u0001\u0000\u0000\u0000\u0255\u0258\u0001\u0000\u0000\u0000\u0256"+
		"\u0254\u0001\u0000\u0000\u0000\u0256\u0257\u0001\u0000\u0000\u0000\u0257"+
		"\u0259\u0001\u0000\u0000\u0000\u0258\u0256\u0001\u0000\u0000\u0000\u0259"+
		"\u025a\u0005N\u0000\u0000\u025a\u028c\u0001\u0000\u0000\u0000\u025b\u025c"+
		"\u0005M\u0000\u0000\u025c\u0261\u0003&\u0013\u0000\u025d\u025e\u0005Q"+
		"\u0000\u0000\u025e\u0260\u0003&\u0013\u0000\u025f\u025d\u0001\u0000\u0000"+
		"\u0000\u0260\u0263\u0001\u0000\u0000\u0000\u0261\u025f\u0001\u0000\u0000"+
		"\u0000\u0261\u0262\u0001\u0000\u0000\u0000\u0262\u0264\u0001\u0000\u0000"+
		"\u0000\u0263\u0261\u0001\u0000\u0000\u0000\u0264\u0265\u0005N\u0000\u0000"+
		"\u0265\u028c\u0001\u0000\u0000\u0000\u0266\u0267\u0005M\u0000\u0000\u0267"+
		"\u026c\u0003(\u0014\u0000\u0268\u0269\u0005Q\u0000\u0000\u0269\u026b\u0003"+
		"(\u0014\u0000\u026a\u0268\u0001\u0000\u0000\u0000\u026b\u026e\u0001\u0000"+
		"\u0000\u0000\u026c\u026a\u0001\u0000\u0000\u0000\u026c\u026d\u0001\u0000"+
		"\u0000\u0000\u026d\u026f\u0001\u0000\u0000\u0000\u026e\u026c\u0001\u0000"+
		"\u0000\u0000\u026f\u0270\u0005N\u0000\u0000\u0270\u028c\u0001\u0000\u0000"+
		"\u0000\u0271\u0272\u0005M\u0000\u0000\u0272\u0277\u0003*\u0015\u0000\u0273"+
		"\u0274\u0005Q\u0000\u0000\u0274\u0276\u0003*\u0015\u0000\u0275\u0273\u0001"+
		"\u0000\u0000\u0000\u0276\u0279\u0001\u0000\u0000\u0000\u0277\u0275\u0001"+
		"\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278\u027a\u0001"+
		"\u0000\u0000\u0000\u0279\u0277\u0001\u0000\u0000\u0000\u027a\u027b\u0005"+
		"N\u0000\u0000\u027b\u028c\u0001\u0000\u0000\u0000\u027c\u027d\u0005M\u0000"+
		"\u0000\u027d\u0282\u0003,\u0016\u0000\u027e\u027f\u0005Q\u0000\u0000\u027f"+
		"\u0281\u0003,\u0016\u0000\u0280\u027e\u0001\u0000\u0000\u0000\u0281\u0284"+
		"\u0001\u0000\u0000\u0000\u0282\u0280\u0001\u0000\u0000\u0000\u0282\u0283"+
		"\u0001\u0000\u0000\u0000\u0283\u0285\u0001\u0000\u0000\u0000\u0284\u0282"+
		"\u0001\u0000\u0000\u0000\u0285\u0286\u0005N\u0000\u0000\u0286\u028c\u0001"+
		"\u0000\u0000\u0000\u0287\u0289\u0005d\u0000\u0000\u0288\u0287\u0001\u0000"+
		"\u0000\u0000\u0288\u0289\u0001\u0000\u0000\u0000\u0289\u028a\u0001\u0000"+
		"\u0000\u0000\u028a\u028c\u0005V\u0000\u0000\u028b\u0245\u0001\u0000\u0000"+
		"\u0000\u028b\u0250\u0001\u0000\u0000\u0000\u028b\u025b\u0001\u0000\u0000"+
		"\u0000\u028b\u0266\u0001\u0000\u0000\u0000\u028b\u0271\u0001\u0000\u0000"+
		"\u0000\u028b\u027c\u0001\u0000\u0000\u0000\u028b\u0288\u0001\u0000\u0000"+
		"\u0000\u028c/\u0001\u0000\u0000\u0000\u028d\u028e\u0005M\u0000\u0000\u028e"+
		"\u0293\u0005V\u0000\u0000\u028f\u0290\u0005Q\u0000\u0000\u0290\u0292\u0005"+
		"V\u0000\u0000\u0291\u028f\u0001\u0000\u0000\u0000\u0292\u0295\u0001\u0000"+
		"\u0000\u0000\u0293\u0291\u0001\u0000\u0000\u0000\u0293\u0294\u0001\u0000"+
		"\u0000\u0000\u0294\u0296\u0001\u0000\u0000\u0000\u0295\u0293\u0001\u0000"+
		"\u0000\u0000\u0296\u0297\u0005N\u0000\u0000\u02971\u0001\u0000\u0000\u0000"+
		"C49BFSWu}\u0098\u00ac\u00ae\u00b4\u00c2\u00dd\u00e0\u00e2\u00ef\u00f2"+
		"\u00f4\u0101\u0104\u0106\u0109\u0112\u0117\u0122\u012b\u0137\u0149\u0151"+
		"\u0155\u0158\u0163\u0175\u0182\u0186\u018a\u018c\u0197\u01a9\u01b2\u01b6"+
		"\u01b9\u01c4\u01d6\u01e0\u01e4\u01e7\u01f2\u0204\u020e\u0212\u0215\u0220"+
		"\u0232\u023c\u0240\u0243\u024b\u0256\u0261\u026c\u0277\u0282\u0288\u028b"+
		"\u0293";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}