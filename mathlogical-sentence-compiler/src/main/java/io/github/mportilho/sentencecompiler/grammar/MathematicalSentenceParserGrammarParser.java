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
		DATE=91, TIME=92, TIME_OFFSET=93, DATETIME=94, BOOLEAN_TYPE=95, NUMBER_TYPE=96, 
		STRING_TYPE=97, DATE_TYPE=98, TIME_TYPE=99, DATETIME_TYPE=100, VECTOR_TYPE=101, 
		COMMENT=102, WS=103;
	public static final int
		RULE_start = 0, RULE_mathStart = 1, RULE_logicalStart = 2, RULE_assignmentExpression = 3, 
		RULE_logicalExpression = 4, RULE_mathExpression = 5, RULE_mathSpecificFunction = 6, 
		RULE_logarithmFunction = 7, RULE_roundingFunction = 8, RULE_sequenceFunction = 9, 
		RULE_dateOperation = 10, RULE_timeOperation = 11, RULE_dateTimeOperation = 12, 
		RULE_function = 13, RULE_comparisonOperator = 14, RULE_logicalOperator = 15, 
		RULE_allEntityTypes = 16, RULE_scalarEntityTypes = 17, RULE_logicalEntity = 18, 
		RULE_numericEntity = 19, RULE_stringEntity = 20, RULE_dateEntity = 21, 
		RULE_timeEntity = 22, RULE_dateTimeEntity = 23, RULE_vectorEntity = 24, 
		RULE_vectorOfVariables = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "mathStart", "logicalStart", "assignmentExpression", "logicalExpression", 
			"mathExpression", "mathSpecificFunction", "logarithmFunction", "roundingFunction", 
			"sequenceFunction", "dateOperation", "timeOperation", "dateTimeOperation", 
			"function", "comparisonOperator", "logicalOperator", "allEntityTypes", 
			"scalarEntityTypes", "logicalEntity", "numericEntity", "stringEntity", 
			"dateEntity", "timeEntity", "dateTimeEntity", "vectorEntity", "vectorOfVariables"
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
			null, null, null, null, null, null, null, "'<bool>'", "'<number>'", "'<text>'", 
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
			"TIME_OFFSET", "DATETIME", "BOOLEAN_TYPE", "NUMBER_TYPE", "STRING_TYPE", 
			"DATE_TYPE", "TIME_TYPE", "DATETIME_TYPE", "VECTOR_TYPE", "COMMENT", 
			"WS"
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
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				mathStart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
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
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(56);
					assignmentExpression();
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(62);
			mathExpression(0);
			setState(63);
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
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(65);
					assignmentExpression();
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 130595661806579714L) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 66812929L) != 0)) {
				{
				setState(71);
				logicalExpression(0);
				}
			}

			setState(74);
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
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new AssignOperationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(IDENTIFIER);
				setState(77);
				match(EQ);
				setState(78);
				allEntityTypes();
				setState(79);
				match(SEMI);
				}
				break;
			case LBLACKET:
				_localctx = new DestructuringAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				vectorOfVariables();
				setState(82);
				match(EQ);
				setState(85);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(83);
					vectorEntity();
					}
					break;
				case 2:
					{
					setState(84);
					function();
					}
					break;
				}
				setState(87);
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
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(92);
				_la = _input.LA(1);
				if ( !(_la==EXCLAMATION || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(93);
				logicalExpression(9);
				}
				break;
			case 2:
				{
				_localctx = new ComparisonMathExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				mathExpression(0);
				setState(95);
				comparisonOperator();
				setState(96);
				mathExpression(0);
				}
				break;
			case 3:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				stringEntity();
				setState(99);
				comparisonOperator();
				setState(100);
				stringEntity();
				}
				break;
			case 4:
				{
				_localctx = new DateExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				dateOperation();
				setState(103);
				comparisonOperator();
				setState(104);
				dateOperation();
				}
				break;
			case 5:
				{
				_localctx = new TimeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				timeOperation();
				setState(107);
				comparisonOperator();
				setState(108);
				timeOperation();
				}
				break;
			case 6:
				{
				_localctx = new DateTimeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				dateTimeOperation();
				setState(111);
				comparisonOperator();
				setState(112);
				dateTimeOperation();
				}
				break;
			case 7:
				{
				_localctx = new LogicalParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				match(LPAREN);
				setState(115);
				logicalExpression(0);
				setState(116);
				match(RPAREN);
				}
				break;
			case 8:
				{
				_localctx = new LogicalValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				logicalEntity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(127);
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
					setState(121);
					if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
					setState(122);
					logicalOperator();
					setState(123);
					logicalExpression(9);
					}
					} 
				}
				setState(129);
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
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new MathParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(131);
				match(LPAREN);
				setState(132);
				mathExpression(0);
				setState(133);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new NegateMathParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(MINUS_PARENTHESIS);
				setState(136);
				mathExpression(0);
				setState(137);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new SquareRootExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(SQRT);
				setState(140);
				match(LPAREN);
				setState(141);
				mathExpression(0);
				setState(142);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new DaysSubtractionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				dateEntity();
				setState(145);
				match(MINUS);
				setState(146);
				dateEntity();
				}
				break;
			case 5:
				{
				_localctx = new ModulusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				match(MODULUS);
				setState(149);
				mathExpression(0);
				setState(150);
				match(MODULUS);
				}
				break;
			case 6:
				{
				_localctx = new MathSpecificExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				mathSpecificFunction();
				}
				break;
			case 7:
				{
				_localctx = new NumberValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				numericEntity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(174);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new RootExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(156);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(157);
						match(ROOT);
						setState(158);
						mathExpression(11);
						}
						break;
					case 2:
						{
						_localctx = new ExponentiationExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(159);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(160);
						match(EXPONENTIATION);
						setState(161);
						mathExpression(8);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicationExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(162);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(163);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 573440L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(164);
						mathExpression(8);
						}
						break;
					case 4:
						{
						_localctx = new SumExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(165);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(166);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(167);
						mathExpression(7);
						}
						break;
					case 5:
						{
						_localctx = new PercentExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(168);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(169);
						match(PERCENT);
						}
						break;
					case 6:
						{
						_localctx = new FactorialExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(170);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(171);
						match(EXCLAMATION);
						}
						break;
					case 7:
						{
						_localctx = new DegreeExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(172);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(173);
						match(DEGREE);
						}
						break;
					}
					} 
				}
				setState(178);
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
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BINARY_LOGARITHM:
			case NATURAL_LOGARITHM:
			case COMMOM_LOGARITHM:
			case LOGARITHM:
				_localctx = new LogarithmExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
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
				setState(180);
				roundingFunction();
				}
				break;
			case SUMMATION:
			case PRODUCT_SEQUENCE:
				_localctx = new SequenceExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
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
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BINARY_LOGARITHM:
			case NATURAL_LOGARITHM:
			case COMMOM_LOGARITHM:
				_localctx = new FixedLogarithmContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 234881024L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(185);
				match(LPAREN);
				setState(186);
				mathExpression(0);
				setState(187);
				match(RPAREN);
				}
				break;
			case LOGARITHM:
				_localctx = new VariableLogarithmContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(LOGARITHM);
				setState(190);
				match(LPAREN);
				setState(191);
				mathExpression(0);
				setState(192);
				match(COMMA);
				setState(193);
				mathExpression(0);
				setState(194);
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
			setState(198);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4486007441326080L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(199);
			match(LPAREN);
			setState(200);
			mathExpression(0);
			setState(201);
			match(COMMA);
			setState(202);
			mathExpression(0);
			setState(203);
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
			setState(205);
			_la = _input.LA(1);
			if ( !(_la==SUMMATION || _la==PRODUCT_SEQUENCE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(206);
			vectorEntity();
			setState(207);
			match(RBLACKET);
			setState(208);
			match(LPAREN);
			setState(209);
			mathExpression(0);
			setState(210);
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
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new DateParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(LPAREN);
				setState(213);
				dateOperation();
				setState(214);
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
				setState(216);
				dateEntity();
				setState(226);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(217);
					match(DATE_OPERATIONS);
					setState(218);
					mathExpression(0);
					setState(223);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(219);
							match(DATE_OPERATIONS);
							setState(220);
							mathExpression(0);
							}
							} 
						}
						setState(225);
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
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new TimeParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(LPAREN);
				setState(231);
				timeOperation();
				setState(232);
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
				setState(234);
				timeEntity();
				setState(244);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(235);
					match(TIME_OPERATIONS);
					setState(236);
					mathExpression(0);
					setState(241);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(237);
							match(TIME_OPERATIONS);
							setState(238);
							mathExpression(0);
							}
							} 
						}
						setState(243);
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
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new DateTimeParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(LPAREN);
				setState(249);
				dateTimeOperation();
				setState(250);
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
				setState(252);
				dateTimeEntity();
				setState(262);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
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
					setState(259);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(255);
							_la = _input.LA(1);
							if ( !(_la==DATE_OPERATIONS || _la==TIME_OPERATIONS) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							setState(256);
							mathExpression(0);
							}
							} 
						}
						setState(261);
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
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CACHE_FUNCTION_PREFIX) {
				{
				setState(266);
				match(CACHE_FUNCTION_PREFIX);
				}
			}

			setState(269);
			match(IDENTIFIER);
			setState(270);
			match(LPAREN);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 130595661806579714L) != 0) || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 133921797L) != 0)) {
				{
				{
				setState(271);
				allEntityTypes();
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA || _la==SEMI) {
					{
					{
					setState(272);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==SEMI) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(273);
					allEntityTypes();
					}
					}
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(284);
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
			setState(286);
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
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(AND);
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(OR);
				}
				break;
			case XOR:
			case XNOR:
			case NAND:
			case NOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
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
				setState(291);
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
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				mathExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				logicalExpression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
				dateOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(297);
				timeOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(298);
				dateTimeOperation();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(299);
				stringEntity();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(300);
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
	public static class ScalarEntityTypesContext extends ParserRuleContext {
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
		public ScalarEntityTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarEntityTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterScalarEntityTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitScalarEntityTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitScalarEntityTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarEntityTypesContext scalarEntityTypes() throws RecognitionException {
		ScalarEntityTypesContext _localctx = new ScalarEntityTypesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_scalarEntityTypes);
		try {
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				mathExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				logicalExpression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				dateOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(306);
				timeOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(307);
				dateTimeOperation();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(308);
				stringEntity();
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
		enterRule(_localctx, 36, RULE_logicalEntity);
		int _la;
		try {
			int _alt;
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new LogicalConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
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
				setState(312);
				match(IF);
				setState(313);
				logicalExpression(0);
				setState(314);
				match(THEN);
				setState(315);
				logicalExpression(0);
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(316);
					match(ELSEIF);
					setState(317);
					logicalExpression(0);
					setState(318);
					match(THEN);
					setState(319);
					logicalExpression(0);
					}
				}

				setState(323);
				match(ELSE);
				setState(324);
				logicalExpression(0);
				setState(325);
				match(ENDIF);
				}
				break;
			case 3:
				_localctx = new LogicalFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(327);
				match(IF);
				setState(328);
				match(LPAREN);
				setState(329);
				logicalExpression(0);
				setState(330);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(331);
				logicalExpression(0);
				setState(339);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
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
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(335);
						logicalExpression(0);
						}
						} 
					}
					setState(341);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				setState(342);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(343);
				logicalExpression(0);
				setState(344);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new LogicalFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BOOLEAN_TYPE) {
					{
					setState(346);
					match(BOOLEAN_TYPE);
					}
				}

				setState(349);
				function();
				}
				break;
			case 5:
				_localctx = new LogicalVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BOOLEAN_TYPE) {
					{
					setState(350);
					match(BOOLEAN_TYPE);
					}
				}

				setState(353);
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
		enterRule(_localctx, 38, RULE_numericEntity);
		int _la;
		try {
			int _alt;
			setState(406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				_localctx = new MathDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
				match(IF);
				setState(357);
				logicalExpression(0);
				setState(358);
				match(THEN);
				setState(359);
				mathExpression(0);
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(360);
					match(ELSEIF);
					setState(361);
					logicalExpression(0);
					setState(362);
					match(THEN);
					setState(363);
					mathExpression(0);
					}
				}

				setState(367);
				match(ELSE);
				setState(368);
				mathExpression(0);
				setState(369);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new MathFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				match(IF);
				setState(372);
				match(LPAREN);
				setState(373);
				logicalExpression(0);
				setState(374);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(375);
				mathExpression(0);
				setState(383);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
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
						logicalExpression(0);
						setState(378);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(379);
						mathExpression(0);
						}
						} 
					}
					setState(385);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				}
				setState(386);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(387);
				mathExpression(0);
				setState(388);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new EulerConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(390);
				match(EULER);
				}
				break;
			case 4:
				_localctx = new PiConstantContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(391);
				match(PI);
				}
				break;
			case 5:
				_localctx = new SummationVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(392);
				match(SUMMATION_VARIABLE);
				}
				break;
			case 6:
				_localctx = new ProductSequenceVariableContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(393);
				match(PRODUCT_SEQUENCE_VARIABLE);
				}
				break;
			case 7:
				_localctx = new NumericConstantContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(394);
				match(NUMBER);
				}
				break;
			case 8:
				_localctx = new NumericFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER_TYPE) {
					{
					setState(395);
					match(NUMBER_TYPE);
					}
				}

				setState(398);
				function();
				}
				break;
			case 9:
				_localctx = new NumericVariableContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(404);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
				case NUMBER_TYPE:
					{
					setState(400);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NUMBER_TYPE) {
						{
						setState(399);
						match(NUMBER_TYPE);
						}
					}

					setState(402);
					match(IDENTIFIER);
					}
					break;
				case NEGATIVE_IDENTIFIER:
					{
					setState(403);
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
		enterRule(_localctx, 40, RULE_stringEntity);
		int _la;
		try {
			int _alt;
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				_localctx = new StringDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				match(IF);
				setState(409);
				logicalExpression(0);
				setState(410);
				match(THEN);
				setState(411);
				stringEntity();
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(412);
					match(ELSEIF);
					setState(413);
					logicalExpression(0);
					setState(414);
					match(THEN);
					setState(415);
					stringEntity();
					}
				}

				setState(419);
				match(ELSE);
				setState(420);
				stringEntity();
				setState(421);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new StringFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				match(IF);
				setState(424);
				match(LPAREN);
				setState(425);
				logicalExpression(0);
				setState(426);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(427);
				stringEntity();
				setState(435);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
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
						logicalExpression(0);
						setState(430);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(431);
						stringEntity();
						}
						} 
					}
					setState(437);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				}
				setState(438);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(439);
				stringEntity();
				setState(440);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new StringConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(442);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new StringFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING_TYPE) {
					{
					setState(443);
					match(STRING_TYPE);
					}
				}

				setState(446);
				function();
				}
				break;
			case 5:
				_localctx = new StringVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING_TYPE) {
					{
					setState(447);
					match(STRING_TYPE);
					}
				}

				setState(450);
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
		enterRule(_localctx, 42, RULE_dateEntity);
		int _la;
		try {
			int _alt;
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				_localctx = new DateDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(453);
				match(IF);
				setState(454);
				logicalExpression(0);
				setState(455);
				match(THEN);
				setState(456);
				dateOperation();
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(457);
					match(ELSEIF);
					setState(458);
					logicalExpression(0);
					setState(459);
					match(THEN);
					setState(460);
					dateOperation();
					}
				}

				setState(464);
				match(ELSE);
				setState(465);
				dateOperation();
				setState(466);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new DateFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
				match(IF);
				setState(469);
				match(LPAREN);
				setState(470);
				logicalExpression(0);
				setState(471);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(472);
				dateOperation();
				setState(480);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
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
						logicalExpression(0);
						setState(475);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(476);
						dateOperation();
						}
						} 
					}
					setState(482);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				}
				setState(483);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(484);
				dateOperation();
				setState(485);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new DateConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(487);
				match(DATE);
				}
				break;
			case 4:
				_localctx = new DateCurrentValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(488);
				match(NOW_DATE);
				}
				break;
			case 5:
				_localctx = new DateVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATE_TYPE) {
					{
					setState(489);
					match(DATE_TYPE);
					}
				}

				setState(492);
				match(IDENTIFIER);
				}
				break;
			case 6:
				_localctx = new DateFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATE_TYPE) {
					{
					setState(493);
					match(DATE_TYPE);
					}
				}

				setState(496);
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
		enterRule(_localctx, 44, RULE_timeEntity);
		int _la;
		try {
			int _alt;
			setState(543);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				_localctx = new TimeDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				match(IF);
				setState(500);
				logicalExpression(0);
				setState(501);
				match(THEN);
				setState(502);
				timeOperation();
				setState(508);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(503);
					match(ELSEIF);
					setState(504);
					logicalExpression(0);
					setState(505);
					match(THEN);
					setState(506);
					timeOperation();
					}
				}

				setState(510);
				match(ELSE);
				setState(511);
				timeOperation();
				setState(512);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new TimeFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				match(IF);
				setState(515);
				match(LPAREN);
				setState(516);
				logicalExpression(0);
				setState(517);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(518);
				timeOperation();
				setState(526);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
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
						logicalExpression(0);
						setState(521);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(522);
						timeOperation();
						}
						} 
					}
					setState(528);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
				}
				setState(529);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(530);
				timeOperation();
				setState(531);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new TimeConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(533);
				match(TIME);
				}
				break;
			case 4:
				_localctx = new TimeCurrentValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(534);
				match(NOW_TIME);
				}
				break;
			case 5:
				_localctx = new TimeVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(536);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TIME_TYPE) {
					{
					setState(535);
					match(TIME_TYPE);
					}
				}

				setState(538);
				match(IDENTIFIER);
				}
				break;
			case 6:
				_localctx = new TimeFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TIME_TYPE) {
					{
					setState(539);
					match(TIME_TYPE);
					}
				}

				setState(542);
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
		public TerminalNode TIME_OFFSET() { return getToken(MathematicalSentenceParserGrammarParser.TIME_OFFSET, 0); }
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
		enterRule(_localctx, 46, RULE_dateTimeEntity);
		int _la;
		try {
			int _alt;
			setState(592);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				_localctx = new DateTimeDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(545);
				match(IF);
				setState(546);
				logicalExpression(0);
				setState(547);
				match(THEN);
				setState(548);
				dateTimeOperation();
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(549);
					match(ELSEIF);
					setState(550);
					logicalExpression(0);
					setState(551);
					match(THEN);
					setState(552);
					dateTimeOperation();
					}
				}

				setState(556);
				match(ELSE);
				setState(557);
				dateTimeOperation();
				setState(558);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new DateTimeFunctionDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(560);
				match(IF);
				setState(561);
				match(LPAREN);
				setState(562);
				logicalExpression(0);
				setState(563);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(564);
				dateTimeOperation();
				setState(572);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
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
						logicalExpression(0);
						setState(567);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==SEMI) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(568);
						dateTimeOperation();
						}
						} 
					}
					setState(574);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				}
				setState(575);
				_la = _input.LA(1);
				if ( !(_la==COMMA || _la==SEMI) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(576);
				dateTimeOperation();
				setState(577);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new DateTimeConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(579);
				match(DATETIME);
				setState(581);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					setState(580);
					match(TIME_OFFSET);
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new DateTimeCurrentValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(583);
				match(NOW_DATETIME);
				}
				break;
			case 5:
				_localctx = new DateTimeVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATETIME_TYPE) {
					{
					setState(584);
					match(DATETIME_TYPE);
					}
				}

				setState(587);
				match(IDENTIFIER);
				}
				break;
			case 6:
				_localctx = new DateTimeFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(589);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATETIME_TYPE) {
					{
					setState(588);
					match(DATETIME_TYPE);
					}
				}

				setState(591);
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
	@SuppressWarnings("CheckReturnValue")
	public static class VectorOfExpressionsContext extends VectorEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<ScalarEntityTypesContext> scalarEntityTypes() {
			return getRuleContexts(ScalarEntityTypesContext.class);
		}
		public ScalarEntityTypesContext scalarEntityTypes(int i) {
			return getRuleContext(ScalarEntityTypesContext.class,i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public VectorOfExpressionsContext(VectorEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterVectorOfExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitVectorOfExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitVectorOfExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorEntityContext vectorEntity() throws RecognitionException {
		VectorEntityContext _localctx = new VectorEntityContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_vectorEntity);
		int _la;
		try {
			setState(675);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				_localctx = new VectorOfNumbersContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(594);
				match(LBLACKET);
				setState(595);
				numericEntity();
				setState(600);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(596);
					match(COMMA);
					setState(597);
					numericEntity();
					}
					}
					setState(602);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(603);
				match(RBLACKET);
				}
				break;
			case 2:
				_localctx = new VectorOfBooleansContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(605);
				match(LBLACKET);
				setState(606);
				logicalEntity();
				setState(611);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(607);
					match(COMMA);
					setState(608);
					logicalEntity();
					}
					}
					setState(613);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(614);
				match(RBLACKET);
				}
				break;
			case 3:
				_localctx = new VectorOfStringsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(616);
				match(LBLACKET);
				setState(617);
				stringEntity();
				setState(622);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(618);
					match(COMMA);
					setState(619);
					stringEntity();
					}
					}
					setState(624);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(625);
				match(RBLACKET);
				}
				break;
			case 4:
				_localctx = new VectorOfDatesContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(627);
				match(LBLACKET);
				setState(628);
				dateEntity();
				setState(633);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(629);
					match(COMMA);
					setState(630);
					dateEntity();
					}
					}
					setState(635);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(636);
				match(RBLACKET);
				}
				break;
			case 5:
				_localctx = new VectorOfTimesContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(638);
				match(LBLACKET);
				setState(639);
				timeEntity();
				setState(644);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(640);
					match(COMMA);
					setState(641);
					timeEntity();
					}
					}
					setState(646);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(647);
				match(RBLACKET);
				}
				break;
			case 6:
				_localctx = new VectorOfDateTimesContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(649);
				match(LBLACKET);
				setState(650);
				dateTimeEntity();
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(651);
					match(COMMA);
					setState(652);
					dateTimeEntity();
					}
					}
					setState(657);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(658);
				match(RBLACKET);
				}
				break;
			case 7:
				_localctx = new VectorOfExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(660);
				match(LBLACKET);
				setState(661);
				scalarEntityTypes();
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(662);
					match(COMMA);
					setState(663);
					scalarEntityTypes();
					}
					}
					setState(668);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(669);
				match(RBLACKET);
				}
				break;
			case 8:
				_localctx = new VectorVariableContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(672);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VECTOR_TYPE) {
					{
					setState(671);
					match(VECTOR_TYPE);
					}
				}

				setState(674);
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
		enterRule(_localctx, 50, RULE_vectorOfVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
			match(LBLACKET);
			setState(678);
			match(IDENTIFIER);
			setState(683);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(679);
				match(COMMA);
				setState(680);
				match(IDENTIFIER);
				}
				}
				setState(685);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(686);
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
		"\u0004\u0001g\u02b1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0003\u00007\b\u0000"+
		"\u0001\u0001\u0005\u0001:\b\u0001\n\u0001\f\u0001=\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002C\b\u0002\n\u0002\f\u0002"+
		"F\t\u0002\u0001\u0002\u0003\u0002I\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003V\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003Z\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004x\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004~\b\u0004\n\u0004\f\u0004\u0081\t\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u009b\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u00af\b\u0005\n\u0005\f\u0005\u00b2\t\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00b7\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00c5"+
		"\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00de\b\n\n"+
		"\n\f\n\u00e1\t\n\u0003\n\u00e3\b\n\u0003\n\u00e5\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00f0\b\u000b\n\u000b\f\u000b\u00f3\t\u000b"+
		"\u0003\u000b\u00f5\b\u000b\u0003\u000b\u00f7\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0102\b\f\n"+
		"\f\f\f\u0105\t\f\u0003\f\u0107\b\f\u0003\f\u0109\b\f\u0001\r\u0003\r\u010c"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0113\b\r\n\r\f\r"+
		"\u0116\t\r\u0005\r\u0118\b\r\n\r\f\r\u011b\t\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u0125\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u012e\b\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0136\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0142\b\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u0152\b\u0012\n\u0012\f\u0012\u0155"+
		"\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u015c\b\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0160\b\u0012"+
		"\u0001\u0012\u0003\u0012\u0163\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u016e\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u017e\b\u0013"+
		"\n\u0013\f\u0013\u0181\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u018d\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0191"+
		"\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0195\b\u0013\u0003\u0013"+
		"\u0197\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u01a2\b\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u01b2\b\u0014\n\u0014\f\u0014\u01b5"+
		"\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u01bd\b\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u01c1"+
		"\b\u0014\u0001\u0014\u0003\u0014\u01c4\b\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u01cf\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u01df\b\u0015\n\u0015\f\u0015\u01e2\t\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u01eb"+
		"\b\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u01ef\b\u0015\u0001\u0015"+
		"\u0003\u0015\u01f2\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u01fd\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u020d\b\u0016\n\u0016"+
		"\f\u0016\u0210\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0219\b\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u021d\b\u0016\u0001\u0016\u0003\u0016\u0220\b"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u022b\b\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u023b\b\u0017\n\u0017\f\u0017\u023e\t\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u0246\b\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u024a\b"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u024e\b\u0017\u0001\u0017\u0003"+
		"\u0017\u0251\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u0257\b\u0018\n\u0018\f\u0018\u025a\t\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0262\b\u0018"+
		"\n\u0018\f\u0018\u0265\t\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u026d\b\u0018\n\u0018\f\u0018"+
		"\u0270\t\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0005\u0018\u0278\b\u0018\n\u0018\f\u0018\u027b\t\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u0283\b\u0018\n\u0018\f\u0018\u0286\t\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u028e\b\u0018"+
		"\n\u0018\f\u0018\u0291\t\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0299\b\u0018\n\u0018\f\u0018"+
		"\u029c\t\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u02a1\b"+
		"\u0018\u0001\u0018\u0003\u0018\u02a4\b\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0005\u0019\u02aa\b\u0019\n\u0019\f\u0019\u02ad\t\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0000\u0002\b\n\u001a\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02\u0000\f\u0002\u0000\u0015\u0015++\u0002\u0000\u000e\u000f"+
		"\u0013\u0013\u0001\u0000\u0010\u0011\u0001\u0000\u0019\u001b\u0001\u0000"+
		",3\u0001\u0000\u001d\u001e\u0001\u000045\u0001\u0000QR\u0001\u0000%*\u0001"+
		"\u0000\b\u000b\u0001\u0000)*\u0001\u0000\f\r\u0317\u00006\u0001\u0000"+
		"\u0000\u0000\u0002;\u0001\u0000\u0000\u0000\u0004D\u0001\u0000\u0000\u0000"+
		"\u0006Y\u0001\u0000\u0000\u0000\bw\u0001\u0000\u0000\u0000\n\u009a\u0001"+
		"\u0000\u0000\u0000\f\u00b6\u0001\u0000\u0000\u0000\u000e\u00c4\u0001\u0000"+
		"\u0000\u0000\u0010\u00c6\u0001\u0000\u0000\u0000\u0012\u00cd\u0001\u0000"+
		"\u0000\u0000\u0014\u00e4\u0001\u0000\u0000\u0000\u0016\u00f6\u0001\u0000"+
		"\u0000\u0000\u0018\u0108\u0001\u0000\u0000\u0000\u001a\u010b\u0001\u0000"+
		"\u0000\u0000\u001c\u011e\u0001\u0000\u0000\u0000\u001e\u0124\u0001\u0000"+
		"\u0000\u0000 \u012d\u0001\u0000\u0000\u0000\"\u0135\u0001\u0000\u0000"+
		"\u0000$\u0162\u0001\u0000\u0000\u0000&\u0196\u0001\u0000\u0000\u0000("+
		"\u01c3\u0001\u0000\u0000\u0000*\u01f1\u0001\u0000\u0000\u0000,\u021f\u0001"+
		"\u0000\u0000\u0000.\u0250\u0001\u0000\u0000\u00000\u02a3\u0001\u0000\u0000"+
		"\u00002\u02a5\u0001\u0000\u0000\u000047\u0003\u0002\u0001\u000057\u0003"+
		"\u0004\u0002\u000064\u0001\u0000\u0000\u000065\u0001\u0000\u0000\u0000"+
		"7\u0001\u0001\u0000\u0000\u00008:\u0003\u0006\u0003\u000098\u0001\u0000"+
		"\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		">?\u0003\n\u0005\u0000?@\u0005\u0000\u0000\u0001@\u0003\u0001\u0000\u0000"+
		"\u0000AC\u0003\u0006\u0003\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000"+
		"\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EH\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000GI\u0003\b\u0004\u0000HG\u0001"+
		"\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"JK\u0005\u0000\u0000\u0001K\u0005\u0001\u0000\u0000\u0000LM\u0005V\u0000"+
		"\u0000MN\u0005)\u0000\u0000NO\u0003 \u0010\u0000OP\u0005R\u0000\u0000"+
		"PZ\u0001\u0000\u0000\u0000QR\u00032\u0019\u0000RU\u0005)\u0000\u0000S"+
		"V\u00030\u0018\u0000TV\u0003\u001a\r\u0000US\u0001\u0000\u0000\u0000U"+
		"T\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0005R\u0000\u0000"+
		"XZ\u0001\u0000\u0000\u0000YL\u0001\u0000\u0000\u0000YQ\u0001\u0000\u0000"+
		"\u0000Z\u0007\u0001\u0000\u0000\u0000[\\\u0006\u0004\uffff\uffff\u0000"+
		"\\]\u0007\u0000\u0000\u0000]x\u0003\b\u0004\t^_\u0003\n\u0005\u0000_`"+
		"\u0003\u001c\u000e\u0000`a\u0003\n\u0005\u0000ax\u0001\u0000\u0000\u0000"+
		"bc\u0003(\u0014\u0000cd\u0003\u001c\u000e\u0000de\u0003(\u0014\u0000e"+
		"x\u0001\u0000\u0000\u0000fg\u0003\u0014\n\u0000gh\u0003\u001c\u000e\u0000"+
		"hi\u0003\u0014\n\u0000ix\u0001\u0000\u0000\u0000jk\u0003\u0016\u000b\u0000"+
		"kl\u0003\u001c\u000e\u0000lm\u0003\u0016\u000b\u0000mx\u0001\u0000\u0000"+
		"\u0000no\u0003\u0018\f\u0000op\u0003\u001c\u000e\u0000pq\u0003\u0018\f"+
		"\u0000qx\u0001\u0000\u0000\u0000rs\u0005K\u0000\u0000st\u0003\b\u0004"+
		"\u0000tu\u0005L\u0000\u0000ux\u0001\u0000\u0000\u0000vx\u0003$\u0012\u0000"+
		"w[\u0001\u0000\u0000\u0000w^\u0001\u0000\u0000\u0000wb\u0001\u0000\u0000"+
		"\u0000wf\u0001\u0000\u0000\u0000wj\u0001\u0000\u0000\u0000wn\u0001\u0000"+
		"\u0000\u0000wr\u0001\u0000\u0000\u0000wv\u0001\u0000\u0000\u0000x\u007f"+
		"\u0001\u0000\u0000\u0000yz\n\b\u0000\u0000z{\u0003\u001e\u000f\u0000{"+
		"|\u0003\b\u0004\t|~\u0001\u0000\u0000\u0000}y\u0001\u0000\u0000\u0000"+
		"~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\t\u0001\u0000\u0000\u0000\u0081\u007f\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0006\u0005\uffff\uffff\u0000\u0083\u0084"+
		"\u0005K\u0000\u0000\u0084\u0085\u0003\n\u0005\u0000\u0085\u0086\u0005"+
		"L\u0000\u0000\u0086\u009b\u0001\u0000\u0000\u0000\u0087\u0088\u0005!\u0000"+
		"\u0000\u0088\u0089\u0003\n\u0005\u0000\u0089\u008a\u0005L\u0000\u0000"+
		"\u008a\u009b\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u0018\u0000\u0000"+
		"\u008c\u008d\u0005K\u0000\u0000\u008d\u008e\u0003\n\u0005\u0000\u008e"+
		"\u008f\u0005L\u0000\u0000\u008f\u009b\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0003*\u0015\u0000\u0091\u0092\u0005\u0011\u0000\u0000\u0092\u0093\u0003"+
		"*\u0015\u0000\u0093\u009b\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u0014"+
		"\u0000\u0000\u0095\u0096\u0003\n\u0005\u0000\u0096\u0097\u0005\u0014\u0000"+
		"\u0000\u0097\u009b\u0001\u0000\u0000\u0000\u0098\u009b\u0003\f\u0006\u0000"+
		"\u0099\u009b\u0003&\u0013\u0000\u009a\u0082\u0001\u0000\u0000\u0000\u009a"+
		"\u0087\u0001\u0000\u0000\u0000\u009a\u008b\u0001\u0000\u0000\u0000\u009a"+
		"\u0090\u0001\u0000\u0000\u0000\u009a\u0094\u0001\u0000\u0000\u0000\u009a"+
		"\u0098\u0001\u0000\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b"+
		"\u00b0\u0001\u0000\u0000\u0000\u009c\u009d\n\n\u0000\u0000\u009d\u009e"+
		"\u0005\u0017\u0000\u0000\u009e\u00af\u0003\n\u0005\u000b\u009f\u00a0\n"+
		"\b\u0000\u0000\u00a0\u00a1\u0005\u0016\u0000\u0000\u00a1\u00af\u0003\n"+
		"\u0005\b\u00a2\u00a3\n\u0007\u0000\u0000\u00a3\u00a4\u0007\u0001\u0000"+
		"\u0000\u00a4\u00af\u0003\n\u0005\b\u00a5\u00a6\n\u0006\u0000\u0000\u00a6"+
		"\u00a7\u0007\u0002\u0000\u0000\u00a7\u00af\u0003\n\u0005\u0007\u00a8\u00a9"+
		"\n\f\u0000\u0000\u00a9\u00af\u0005\u0012\u0000\u0000\u00aa\u00ab\n\u000b"+
		"\u0000\u0000\u00ab\u00af\u0005\u0015\u0000\u0000\u00ac\u00ad\n\u0003\u0000"+
		"\u0000\u00ad\u00af\u0005$\u0000\u0000\u00ae\u009c\u0001\u0000\u0000\u0000"+
		"\u00ae\u009f\u0001\u0000\u0000\u0000\u00ae\u00a2\u0001\u0000\u0000\u0000"+
		"\u00ae\u00a5\u0001\u0000\u0000\u0000\u00ae\u00a8\u0001\u0000\u0000\u0000"+
		"\u00ae\u00aa\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000"+
		"\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u000b\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b7\u0003\u000e\u0007\u0000"+
		"\u00b4\u00b7\u0003\u0010\b\u0000\u00b5\u00b7\u0003\u0012\t\u0000\u00b6"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b7\r\u0001\u0000\u0000\u0000\u00b8\u00b9"+
		"\u0007\u0003\u0000\u0000\u00b9\u00ba\u0005K\u0000\u0000\u00ba\u00bb\u0003"+
		"\n\u0005\u0000\u00bb\u00bc\u0005L\u0000\u0000\u00bc\u00c5\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0005\u001c\u0000\u0000\u00be\u00bf\u0005K\u0000"+
		"\u0000\u00bf\u00c0\u0003\n\u0005\u0000\u00c0\u00c1\u0005Q\u0000\u0000"+
		"\u00c1\u00c2\u0003\n\u0005\u0000\u00c2\u00c3\u0005L\u0000\u0000\u00c3"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c4\u00b8\u0001\u0000\u0000\u0000\u00c4"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c5\u000f\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0007\u0004\u0000\u0000\u00c7\u00c8\u0005K\u0000\u0000\u00c8\u00c9"+
		"\u0003\n\u0005\u0000\u00c9\u00ca\u0005Q\u0000\u0000\u00ca\u00cb\u0003"+
		"\n\u0005\u0000\u00cb\u00cc\u0005L\u0000\u0000\u00cc\u0011\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0007\u0005\u0000\u0000\u00ce\u00cf\u00030\u0018"+
		"\u0000\u00cf\u00d0\u0005N\u0000\u0000\u00d0\u00d1\u0005K\u0000\u0000\u00d1"+
		"\u00d2\u0003\n\u0005\u0000\u00d2\u00d3\u0005L\u0000\u0000\u00d3\u0013"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005K\u0000\u0000\u00d5\u00d6\u0003"+
		"\u0014\n\u0000\u00d6\u00d7\u0005L\u0000\u0000\u00d7\u00e5\u0001\u0000"+
		"\u0000\u0000\u00d8\u00e2\u0003*\u0015\u0000\u00d9\u00da\u00054\u0000\u0000"+
		"\u00da\u00df\u0003\n\u0005\u0000\u00db\u00dc\u00054\u0000\u0000\u00dc"+
		"\u00de\u0003\n\u0005\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de\u00e1"+
		"\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1\u00df"+
		"\u0001\u0000\u0000\u0000\u00e2\u00d9\u0001\u0000\u0000\u0000\u00e2\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e5\u0001\u0000\u0000\u0000\u00e4\u00d4"+
		"\u0001\u0000\u0000\u0000\u00e4\u00d8\u0001\u0000\u0000\u0000\u00e5\u0015"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005K\u0000\u0000\u00e7\u00e8\u0003"+
		"\u0016\u000b\u0000\u00e8\u00e9\u0005L\u0000\u0000\u00e9\u00f7\u0001\u0000"+
		"\u0000\u0000\u00ea\u00f4\u0003,\u0016\u0000\u00eb\u00ec\u00055\u0000\u0000"+
		"\u00ec\u00f1\u0003\n\u0005\u0000\u00ed\u00ee\u00055\u0000\u0000\u00ee"+
		"\u00f0\u0003\n\u0005\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f5\u0001\u0000\u0000\u0000\u00f3\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f4\u00eb\u0001\u0000\u0000\u0000\u00f4\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00e6"+
		"\u0001\u0000\u0000\u0000\u00f6\u00ea\u0001\u0000\u0000\u0000\u00f7\u0017"+
		"\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005K\u0000\u0000\u00f9\u00fa\u0003"+
		"\u0018\f\u0000\u00fa\u00fb\u0005L\u0000\u0000\u00fb\u0109\u0001\u0000"+
		"\u0000\u0000\u00fc\u0106\u0003.\u0017\u0000\u00fd\u00fe\u0007\u0006\u0000"+
		"\u0000\u00fe\u0103\u0003\n\u0005\u0000\u00ff\u0100\u0007\u0006\u0000\u0000"+
		"\u0100\u0102\u0003\n\u0005\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102"+
		"\u0105\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0001\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105"+
		"\u0103\u0001\u0000\u0000\u0000\u0106\u00fd\u0001\u0000\u0000\u0000\u0106"+
		"\u0107\u0001\u0000\u0000\u0000\u0107\u0109\u0001\u0000\u0000\u0000\u0108"+
		"\u00f8\u0001\u0000\u0000\u0000\u0108\u00fc\u0001\u0000\u0000\u0000\u0109"+
		"\u0019\u0001\u0000\u0000\u0000\u010a\u010c\u0005U\u0000\u0000\u010b\u010a"+
		"\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\u0005V\u0000\u0000\u010e\u0119\u0005"+
		"K\u0000\u0000\u010f\u0114\u0003 \u0010\u0000\u0110\u0111\u0007\u0007\u0000"+
		"\u0000\u0111\u0113\u0003 \u0010\u0000\u0112\u0110\u0001\u0000\u0000\u0000"+
		"\u0113\u0116\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000"+
		"\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000\u0000\u0000"+
		"\u0116\u0114\u0001\u0000\u0000\u0000\u0117\u010f\u0001\u0000\u0000\u0000"+
		"\u0118\u011b\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011c\u0001\u0000\u0000\u0000"+
		"\u011b\u0119\u0001\u0000\u0000\u0000\u011c\u011d\u0005L\u0000\u0000\u011d"+
		"\u001b\u0001\u0000\u0000\u0000\u011e\u011f\u0007\b\u0000\u0000\u011f\u001d"+
		"\u0001\u0000\u0000\u0000\u0120\u0125\u0005\u0006\u0000\u0000\u0121\u0125"+
		"\u0005\u0007\u0000\u0000\u0122\u0125\u0007\t\u0000\u0000\u0123\u0125\u0007"+
		"\n\u0000\u0000\u0124\u0120\u0001\u0000\u0000\u0000\u0124\u0121\u0001\u0000"+
		"\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0123\u0001\u0000"+
		"\u0000\u0000\u0125\u001f\u0001\u0000\u0000\u0000\u0126\u012e\u0003\n\u0005"+
		"\u0000\u0127\u012e\u0003\b\u0004\u0000\u0128\u012e\u0003\u0014\n\u0000"+
		"\u0129\u012e\u0003\u0016\u000b\u0000\u012a\u012e\u0003\u0018\f\u0000\u012b"+
		"\u012e\u0003(\u0014\u0000\u012c\u012e\u00030\u0018\u0000\u012d\u0126\u0001"+
		"\u0000\u0000\u0000\u012d\u0127\u0001\u0000\u0000\u0000\u012d\u0128\u0001"+
		"\u0000\u0000\u0000\u012d\u0129\u0001\u0000\u0000\u0000\u012d\u012a\u0001"+
		"\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012c\u0001"+
		"\u0000\u0000\u0000\u012e!\u0001\u0000\u0000\u0000\u012f\u0136\u0003\n"+
		"\u0005\u0000\u0130\u0136\u0003\b\u0004\u0000\u0131\u0136\u0003\u0014\n"+
		"\u0000\u0132\u0136\u0003\u0016\u000b\u0000\u0133\u0136\u0003\u0018\f\u0000"+
		"\u0134\u0136\u0003(\u0014\u0000\u0135\u012f\u0001\u0000\u0000\u0000\u0135"+
		"\u0130\u0001\u0000\u0000\u0000\u0135\u0131\u0001\u0000\u0000\u0000\u0135"+
		"\u0132\u0001\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0135"+
		"\u0134\u0001\u0000\u0000\u0000\u0136#\u0001\u0000\u0000\u0000\u0137\u0163"+
		"\u0007\u000b\u0000\u0000\u0138\u0139\u0005\u0001\u0000\u0000\u0139\u013a"+
		"\u0003\b\u0004\u0000\u013a\u013b\u0005\u0002\u0000\u0000\u013b\u0141\u0003"+
		"\b\u0004\u0000\u013c\u013d\u0005\u0004\u0000\u0000\u013d\u013e\u0003\b"+
		"\u0004\u0000\u013e\u013f\u0005\u0002\u0000\u0000\u013f\u0140\u0003\b\u0004"+
		"\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141\u013c\u0001\u0000\u0000"+
		"\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000"+
		"\u0000\u0143\u0144\u0005\u0003\u0000\u0000\u0144\u0145\u0003\b\u0004\u0000"+
		"\u0145\u0146\u0005\u0005\u0000\u0000\u0146\u0163\u0001\u0000\u0000\u0000"+
		"\u0147\u0148\u0005\u0001\u0000\u0000\u0148\u0149\u0005K\u0000\u0000\u0149"+
		"\u014a\u0003\b\u0004\u0000\u014a\u014b\u0007\u0007\u0000\u0000\u014b\u0153"+
		"\u0003\b\u0004\u0000\u014c\u014d\u0007\u0007\u0000\u0000\u014d\u014e\u0003"+
		"\b\u0004\u0000\u014e\u014f\u0007\u0007\u0000\u0000\u014f\u0150\u0003\b"+
		"\u0004\u0000\u0150\u0152\u0001\u0000\u0000\u0000\u0151\u014c\u0001\u0000"+
		"\u0000\u0000\u0152\u0155\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000"+
		"\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0156\u0001\u0000"+
		"\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0156\u0157\u0007\u0007"+
		"\u0000\u0000\u0157\u0158\u0003\b\u0004\u0000\u0158\u0159\u0005L\u0000"+
		"\u0000\u0159\u0163\u0001\u0000\u0000\u0000\u015a\u015c\u0005_\u0000\u0000"+
		"\u015b\u015a\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000"+
		"\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u0163\u0003\u001a\r\u0000\u015e"+
		"\u0160\u0005_\u0000\u0000\u015f\u015e\u0001\u0000\u0000\u0000\u015f\u0160"+
		"\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161\u0163"+
		"\u0005V\u0000\u0000\u0162\u0137\u0001\u0000\u0000\u0000\u0162\u0138\u0001"+
		"\u0000\u0000\u0000\u0162\u0147\u0001\u0000\u0000\u0000\u0162\u015b\u0001"+
		"\u0000\u0000\u0000\u0162\u015f\u0001\u0000\u0000\u0000\u0163%\u0001\u0000"+
		"\u0000\u0000\u0164\u0165\u0005\u0001\u0000\u0000\u0165\u0166\u0003\b\u0004"+
		"\u0000\u0166\u0167\u0005\u0002\u0000\u0000\u0167\u016d\u0003\n\u0005\u0000"+
		"\u0168\u0169\u0005\u0004\u0000\u0000\u0169\u016a\u0003\b\u0004\u0000\u016a"+
		"\u016b\u0005\u0002\u0000\u0000\u016b\u016c\u0003\n\u0005\u0000\u016c\u016e"+
		"\u0001\u0000\u0000\u0000\u016d\u0168\u0001\u0000\u0000\u0000\u016d\u016e"+
		"\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0170"+
		"\u0005\u0003\u0000\u0000\u0170\u0171\u0003\n\u0005\u0000\u0171\u0172\u0005"+
		"\u0005\u0000\u0000\u0172\u0197\u0001\u0000\u0000\u0000\u0173\u0174\u0005"+
		"\u0001\u0000\u0000\u0174\u0175\u0005K\u0000\u0000\u0175\u0176\u0003\b"+
		"\u0004\u0000\u0176\u0177\u0007\u0007\u0000\u0000\u0177\u017f\u0003\n\u0005"+
		"\u0000\u0178\u0179\u0007\u0007\u0000\u0000\u0179\u017a\u0003\b\u0004\u0000"+
		"\u017a\u017b\u0007\u0007\u0000\u0000\u017b\u017c\u0003\n\u0005\u0000\u017c"+
		"\u017e\u0001\u0000\u0000\u0000\u017d\u0178\u0001\u0000\u0000\u0000\u017e"+
		"\u0181\u0001\u0000\u0000\u0000\u017f\u017d\u0001\u0000\u0000\u0000\u017f"+
		"\u0180\u0001\u0000\u0000\u0000\u0180\u0182\u0001\u0000\u0000\u0000\u0181"+
		"\u017f\u0001\u0000\u0000\u0000\u0182\u0183\u0007\u0007\u0000\u0000\u0183"+
		"\u0184\u0003\n\u0005\u0000\u0184\u0185\u0005L\u0000\u0000\u0185\u0197"+
		"\u0001\u0000\u0000\u0000\u0186\u0197\u0005#\u0000\u0000\u0187\u0197\u0005"+
		"\"\u0000\u0000\u0188\u0197\u0005\u001f\u0000\u0000\u0189\u0197\u0005 "+
		"\u0000\u0000\u018a\u0197\u0005Y\u0000\u0000\u018b\u018d\u0005`\u0000\u0000"+
		"\u018c\u018b\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000"+
		"\u018d\u018e\u0001\u0000\u0000\u0000\u018e\u0197\u0003\u001a\r\u0000\u018f"+
		"\u0191\u0005`\u0000\u0000\u0190\u018f\u0001\u0000\u0000\u0000\u0190\u0191"+
		"\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192\u0195"+
		"\u0005V\u0000\u0000\u0193\u0195\u0005W\u0000\u0000\u0194\u0190\u0001\u0000"+
		"\u0000\u0000\u0194\u0193\u0001\u0000\u0000\u0000\u0195\u0197\u0001\u0000"+
		"\u0000\u0000\u0196\u0164\u0001\u0000\u0000\u0000\u0196\u0173\u0001\u0000"+
		"\u0000\u0000\u0196\u0186\u0001\u0000\u0000\u0000\u0196\u0187\u0001\u0000"+
		"\u0000\u0000\u0196\u0188\u0001\u0000\u0000\u0000\u0196\u0189\u0001\u0000"+
		"\u0000\u0000\u0196\u018a\u0001\u0000\u0000\u0000\u0196\u018c\u0001\u0000"+
		"\u0000\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0197\'\u0001\u0000\u0000"+
		"\u0000\u0198\u0199\u0005\u0001\u0000\u0000\u0199\u019a\u0003\b\u0004\u0000"+
		"\u019a\u019b\u0005\u0002\u0000\u0000\u019b\u01a1\u0003(\u0014\u0000\u019c"+
		"\u019d\u0005\u0004\u0000\u0000\u019d\u019e\u0003\b\u0004\u0000\u019e\u019f"+
		"\u0005\u0002\u0000\u0000\u019f\u01a0\u0003(\u0014\u0000\u01a0\u01a2\u0001"+
		"\u0000\u0000\u0000\u01a1\u019c\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001"+
		"\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a4\u0005"+
		"\u0003\u0000\u0000\u01a4\u01a5\u0003(\u0014\u0000\u01a5\u01a6\u0005\u0005"+
		"\u0000\u0000\u01a6\u01c4\u0001\u0000\u0000\u0000\u01a7\u01a8\u0005\u0001"+
		"\u0000\u0000\u01a8\u01a9\u0005K\u0000\u0000\u01a9\u01aa\u0003\b\u0004"+
		"\u0000\u01aa\u01ab\u0007\u0007\u0000\u0000\u01ab\u01b3\u0003(\u0014\u0000"+
		"\u01ac\u01ad\u0007\u0007\u0000\u0000\u01ad\u01ae\u0003\b\u0004\u0000\u01ae"+
		"\u01af\u0007\u0007\u0000\u0000\u01af\u01b0\u0003(\u0014\u0000\u01b0\u01b2"+
		"\u0001\u0000\u0000\u0000\u01b1\u01ac\u0001\u0000\u0000\u0000\u01b2\u01b5"+
		"\u0001\u0000\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b3\u01b4"+
		"\u0001\u0000\u0000\u0000\u01b4\u01b6\u0001\u0000\u0000\u0000\u01b5\u01b3"+
		"\u0001\u0000\u0000\u0000\u01b6\u01b7\u0007\u0007\u0000\u0000\u01b7\u01b8"+
		"\u0003(\u0014\u0000\u01b8\u01b9\u0005L\u0000\u0000\u01b9\u01c4\u0001\u0000"+
		"\u0000\u0000\u01ba\u01c4\u0005X\u0000\u0000\u01bb\u01bd\u0005a\u0000\u0000"+
		"\u01bc\u01bb\u0001\u0000\u0000\u0000\u01bc\u01bd\u0001\u0000\u0000\u0000"+
		"\u01bd\u01be\u0001\u0000\u0000\u0000\u01be\u01c4\u0003\u001a\r\u0000\u01bf"+
		"\u01c1\u0005a\u0000\u0000\u01c0\u01bf\u0001\u0000\u0000\u0000\u01c0\u01c1"+
		"\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000\u0000\u01c2\u01c4"+
		"\u0005V\u0000\u0000\u01c3\u0198\u0001\u0000\u0000\u0000\u01c3\u01a7\u0001"+
		"\u0000\u0000\u0000\u01c3\u01ba\u0001\u0000\u0000\u0000\u01c3\u01bc\u0001"+
		"\u0000\u0000\u0000\u01c3\u01c0\u0001\u0000\u0000\u0000\u01c4)\u0001\u0000"+
		"\u0000\u0000\u01c5\u01c6\u0005\u0001\u0000\u0000\u01c6\u01c7\u0003\b\u0004"+
		"\u0000\u01c7\u01c8\u0005\u0002\u0000\u0000\u01c8\u01ce\u0003\u0014\n\u0000"+
		"\u01c9\u01ca\u0005\u0004\u0000\u0000\u01ca\u01cb\u0003\b\u0004\u0000\u01cb"+
		"\u01cc\u0005\u0002\u0000\u0000\u01cc\u01cd\u0003\u0014\n\u0000\u01cd\u01cf"+
		"\u0001\u0000\u0000\u0000\u01ce\u01c9\u0001\u0000\u0000\u0000\u01ce\u01cf"+
		"\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0\u01d1"+
		"\u0005\u0003\u0000\u0000\u01d1\u01d2\u0003\u0014\n\u0000\u01d2\u01d3\u0005"+
		"\u0005\u0000\u0000\u01d3\u01f2\u0001\u0000\u0000\u0000\u01d4\u01d5\u0005"+
		"\u0001\u0000\u0000\u01d5\u01d6\u0005K\u0000\u0000\u01d6\u01d7\u0003\b"+
		"\u0004\u0000\u01d7\u01d8\u0007\u0007\u0000\u0000\u01d8\u01e0\u0003\u0014"+
		"\n\u0000\u01d9\u01da\u0007\u0007\u0000\u0000\u01da\u01db\u0003\b\u0004"+
		"\u0000\u01db\u01dc\u0007\u0007\u0000\u0000\u01dc\u01dd\u0003\u0014\n\u0000"+
		"\u01dd\u01df\u0001\u0000\u0000\u0000\u01de\u01d9\u0001\u0000\u0000\u0000"+
		"\u01df\u01e2\u0001\u0000\u0000\u0000\u01e0\u01de\u0001\u0000\u0000\u0000"+
		"\u01e0\u01e1\u0001\u0000\u0000\u0000\u01e1\u01e3\u0001\u0000\u0000\u0000"+
		"\u01e2\u01e0\u0001\u0000\u0000\u0000\u01e3\u01e4\u0007\u0007\u0000\u0000"+
		"\u01e4\u01e5\u0003\u0014\n\u0000\u01e5\u01e6\u0005L\u0000\u0000\u01e6"+
		"\u01f2\u0001\u0000\u0000\u0000\u01e7\u01f2\u0005[\u0000\u0000\u01e8\u01f2"+
		"\u00056\u0000\u0000\u01e9\u01eb\u0005b\u0000\u0000\u01ea\u01e9\u0001\u0000"+
		"\u0000\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000\u01eb\u01ec\u0001\u0000"+
		"\u0000\u0000\u01ec\u01f2\u0005V\u0000\u0000\u01ed\u01ef\u0005b\u0000\u0000"+
		"\u01ee\u01ed\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001\u0000\u0000\u0000"+
		"\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f0\u01f2\u0003\u001a\r\u0000\u01f1"+
		"\u01c5\u0001\u0000\u0000\u0000\u01f1\u01d4\u0001\u0000\u0000\u0000\u01f1"+
		"\u01e7\u0001\u0000\u0000\u0000\u01f1\u01e8\u0001\u0000\u0000\u0000\u01f1"+
		"\u01ea\u0001\u0000\u0000\u0000\u01f1\u01ee\u0001\u0000\u0000\u0000\u01f2"+
		"+\u0001\u0000\u0000\u0000\u01f3\u01f4\u0005\u0001\u0000\u0000\u01f4\u01f5"+
		"\u0003\b\u0004\u0000\u01f5\u01f6\u0005\u0002\u0000\u0000\u01f6\u01fc\u0003"+
		"\u0016\u000b\u0000\u01f7\u01f8\u0005\u0004\u0000\u0000\u01f8\u01f9\u0003"+
		"\b\u0004\u0000\u01f9\u01fa\u0005\u0002\u0000\u0000\u01fa\u01fb\u0003\u0016"+
		"\u000b\u0000\u01fb\u01fd\u0001\u0000\u0000\u0000\u01fc\u01f7\u0001\u0000"+
		"\u0000\u0000\u01fc\u01fd\u0001\u0000\u0000\u0000\u01fd\u01fe\u0001\u0000"+
		"\u0000\u0000\u01fe\u01ff\u0005\u0003\u0000\u0000\u01ff\u0200\u0003\u0016"+
		"\u000b\u0000\u0200\u0201\u0005\u0005\u0000\u0000\u0201\u0220\u0001\u0000"+
		"\u0000\u0000\u0202\u0203\u0005\u0001\u0000\u0000\u0203\u0204\u0005K\u0000"+
		"\u0000\u0204\u0205\u0003\b\u0004\u0000\u0205\u0206\u0007\u0007\u0000\u0000"+
		"\u0206\u020e\u0003\u0016\u000b\u0000\u0207\u0208\u0007\u0007\u0000\u0000"+
		"\u0208\u0209\u0003\b\u0004\u0000\u0209\u020a\u0007\u0007\u0000\u0000\u020a"+
		"\u020b\u0003\u0016\u000b\u0000\u020b\u020d\u0001\u0000\u0000\u0000\u020c"+
		"\u0207\u0001\u0000\u0000\u0000\u020d\u0210\u0001\u0000\u0000\u0000\u020e"+
		"\u020c\u0001\u0000\u0000\u0000\u020e\u020f\u0001\u0000\u0000\u0000\u020f"+
		"\u0211\u0001\u0000\u0000\u0000\u0210\u020e\u0001\u0000\u0000\u0000\u0211"+
		"\u0212\u0007\u0007\u0000\u0000\u0212\u0213\u0003\u0016\u000b\u0000\u0213"+
		"\u0214\u0005L\u0000\u0000\u0214\u0220\u0001\u0000\u0000\u0000\u0215\u0220"+
		"\u0005\\\u0000\u0000\u0216\u0220\u00057\u0000\u0000\u0217\u0219\u0005"+
		"c\u0000\u0000\u0218\u0217\u0001\u0000\u0000\u0000\u0218\u0219\u0001\u0000"+
		"\u0000\u0000\u0219\u021a\u0001\u0000\u0000\u0000\u021a\u0220\u0005V\u0000"+
		"\u0000\u021b\u021d\u0005c\u0000\u0000\u021c\u021b\u0001\u0000\u0000\u0000"+
		"\u021c\u021d\u0001\u0000\u0000\u0000\u021d\u021e\u0001\u0000\u0000\u0000"+
		"\u021e\u0220\u0003\u001a\r\u0000\u021f\u01f3\u0001\u0000\u0000\u0000\u021f"+
		"\u0202\u0001\u0000\u0000\u0000\u021f\u0215\u0001\u0000\u0000\u0000\u021f"+
		"\u0216\u0001\u0000\u0000\u0000\u021f\u0218\u0001\u0000\u0000\u0000\u021f"+
		"\u021c\u0001\u0000\u0000\u0000\u0220-\u0001\u0000\u0000\u0000\u0221\u0222"+
		"\u0005\u0001\u0000\u0000\u0222\u0223\u0003\b\u0004\u0000\u0223\u0224\u0005"+
		"\u0002\u0000\u0000\u0224\u022a\u0003\u0018\f\u0000\u0225\u0226\u0005\u0004"+
		"\u0000\u0000\u0226\u0227\u0003\b\u0004\u0000\u0227\u0228\u0005\u0002\u0000"+
		"\u0000\u0228\u0229\u0003\u0018\f\u0000\u0229\u022b\u0001\u0000\u0000\u0000"+
		"\u022a\u0225\u0001\u0000\u0000\u0000\u022a\u022b\u0001\u0000\u0000\u0000"+
		"\u022b\u022c\u0001\u0000\u0000\u0000\u022c\u022d\u0005\u0003\u0000\u0000"+
		"\u022d\u022e\u0003\u0018\f\u0000\u022e\u022f\u0005\u0005\u0000\u0000\u022f"+
		"\u0251\u0001\u0000\u0000\u0000\u0230\u0231\u0005\u0001\u0000\u0000\u0231"+
		"\u0232\u0005K\u0000\u0000\u0232\u0233\u0003\b\u0004\u0000\u0233\u0234"+
		"\u0007\u0007\u0000\u0000\u0234\u023c\u0003\u0018\f\u0000\u0235\u0236\u0007"+
		"\u0007\u0000\u0000\u0236\u0237\u0003\b\u0004\u0000\u0237\u0238\u0007\u0007"+
		"\u0000\u0000\u0238\u0239\u0003\u0018\f\u0000\u0239\u023b\u0001\u0000\u0000"+
		"\u0000\u023a\u0235\u0001\u0000\u0000\u0000\u023b\u023e\u0001\u0000\u0000"+
		"\u0000\u023c\u023a\u0001\u0000\u0000\u0000\u023c\u023d\u0001\u0000\u0000"+
		"\u0000\u023d\u023f\u0001\u0000\u0000\u0000\u023e\u023c\u0001\u0000\u0000"+
		"\u0000\u023f\u0240\u0007\u0007\u0000\u0000\u0240\u0241\u0003\u0018\f\u0000"+
		"\u0241\u0242\u0005L\u0000\u0000\u0242\u0251\u0001\u0000\u0000\u0000\u0243"+
		"\u0245\u0005^\u0000\u0000\u0244\u0246\u0005]\u0000\u0000\u0245\u0244\u0001"+
		"\u0000\u0000\u0000\u0245\u0246\u0001\u0000\u0000\u0000\u0246\u0251\u0001"+
		"\u0000\u0000\u0000\u0247\u0251\u00058\u0000\u0000\u0248\u024a\u0005d\u0000"+
		"\u0000\u0249\u0248\u0001\u0000\u0000\u0000\u0249\u024a\u0001\u0000\u0000"+
		"\u0000\u024a\u024b\u0001\u0000\u0000\u0000\u024b\u0251\u0005V\u0000\u0000"+
		"\u024c\u024e\u0005d\u0000\u0000\u024d\u024c\u0001\u0000\u0000\u0000\u024d"+
		"\u024e\u0001\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000\u0000\u024f"+
		"\u0251\u0003\u001a\r\u0000\u0250\u0221\u0001\u0000\u0000\u0000\u0250\u0230"+
		"\u0001\u0000\u0000\u0000\u0250\u0243\u0001\u0000\u0000\u0000\u0250\u0247"+
		"\u0001\u0000\u0000\u0000\u0250\u0249\u0001\u0000\u0000\u0000\u0250\u024d"+
		"\u0001\u0000\u0000\u0000\u0251/\u0001\u0000\u0000\u0000\u0252\u0253\u0005"+
		"M\u0000\u0000\u0253\u0258\u0003&\u0013\u0000\u0254\u0255\u0005Q\u0000"+
		"\u0000\u0255\u0257\u0003&\u0013\u0000\u0256\u0254\u0001\u0000\u0000\u0000"+
		"\u0257\u025a\u0001\u0000\u0000\u0000\u0258\u0256\u0001\u0000\u0000\u0000"+
		"\u0258\u0259\u0001\u0000\u0000\u0000\u0259\u025b\u0001\u0000\u0000\u0000"+
		"\u025a\u0258\u0001\u0000\u0000\u0000\u025b\u025c\u0005N\u0000\u0000\u025c"+
		"\u02a4\u0001\u0000\u0000\u0000\u025d\u025e\u0005M\u0000\u0000\u025e\u0263"+
		"\u0003$\u0012\u0000\u025f\u0260\u0005Q\u0000\u0000\u0260\u0262\u0003$"+
		"\u0012\u0000\u0261\u025f\u0001\u0000\u0000\u0000\u0262\u0265\u0001\u0000"+
		"\u0000\u0000\u0263\u0261\u0001\u0000\u0000\u0000\u0263\u0264\u0001\u0000"+
		"\u0000\u0000\u0264\u0266\u0001\u0000\u0000\u0000\u0265\u0263\u0001\u0000"+
		"\u0000\u0000\u0266\u0267\u0005N\u0000\u0000\u0267\u02a4\u0001\u0000\u0000"+
		"\u0000\u0268\u0269\u0005M\u0000\u0000\u0269\u026e\u0003(\u0014\u0000\u026a"+
		"\u026b\u0005Q\u0000\u0000\u026b\u026d\u0003(\u0014\u0000\u026c\u026a\u0001"+
		"\u0000\u0000\u0000\u026d\u0270\u0001\u0000\u0000\u0000\u026e\u026c\u0001"+
		"\u0000\u0000\u0000\u026e\u026f\u0001\u0000\u0000\u0000\u026f\u0271\u0001"+
		"\u0000\u0000\u0000\u0270\u026e\u0001\u0000\u0000\u0000\u0271\u0272\u0005"+
		"N\u0000\u0000\u0272\u02a4\u0001\u0000\u0000\u0000\u0273\u0274\u0005M\u0000"+
		"\u0000\u0274\u0279\u0003*\u0015\u0000\u0275\u0276\u0005Q\u0000\u0000\u0276"+
		"\u0278\u0003*\u0015\u0000\u0277\u0275\u0001\u0000\u0000\u0000\u0278\u027b"+
		"\u0001\u0000\u0000\u0000\u0279\u0277\u0001\u0000\u0000\u0000\u0279\u027a"+
		"\u0001\u0000\u0000\u0000\u027a\u027c\u0001\u0000\u0000\u0000\u027b\u0279"+
		"\u0001\u0000\u0000\u0000\u027c\u027d\u0005N\u0000\u0000\u027d\u02a4\u0001"+
		"\u0000\u0000\u0000\u027e\u027f\u0005M\u0000\u0000\u027f\u0284\u0003,\u0016"+
		"\u0000\u0280\u0281\u0005Q\u0000\u0000\u0281\u0283\u0003,\u0016\u0000\u0282"+
		"\u0280\u0001\u0000\u0000\u0000\u0283\u0286\u0001\u0000\u0000\u0000\u0284"+
		"\u0282\u0001\u0000\u0000\u0000\u0284\u0285\u0001\u0000\u0000\u0000\u0285"+
		"\u0287\u0001\u0000\u0000\u0000\u0286\u0284\u0001\u0000\u0000\u0000\u0287"+
		"\u0288\u0005N\u0000\u0000\u0288\u02a4\u0001\u0000\u0000\u0000\u0289\u028a"+
		"\u0005M\u0000\u0000\u028a\u028f\u0003.\u0017\u0000\u028b\u028c\u0005Q"+
		"\u0000\u0000\u028c\u028e\u0003.\u0017\u0000\u028d\u028b\u0001\u0000\u0000"+
		"\u0000\u028e\u0291\u0001\u0000\u0000\u0000\u028f\u028d\u0001\u0000\u0000"+
		"\u0000\u028f\u0290\u0001\u0000\u0000\u0000\u0290\u0292\u0001\u0000\u0000"+
		"\u0000\u0291\u028f\u0001\u0000\u0000\u0000\u0292\u0293\u0005N\u0000\u0000"+
		"\u0293\u02a4\u0001\u0000\u0000\u0000\u0294\u0295\u0005M\u0000\u0000\u0295"+
		"\u029a\u0003\"\u0011\u0000\u0296\u0297\u0005Q\u0000\u0000\u0297\u0299"+
		"\u0003\"\u0011\u0000\u0298\u0296\u0001\u0000\u0000\u0000\u0299\u029c\u0001"+
		"\u0000\u0000\u0000\u029a\u0298\u0001\u0000\u0000\u0000\u029a\u029b\u0001"+
		"\u0000\u0000\u0000\u029b\u029d\u0001\u0000\u0000\u0000\u029c\u029a\u0001"+
		"\u0000\u0000\u0000\u029d\u029e\u0005N\u0000\u0000\u029e\u02a4\u0001\u0000"+
		"\u0000\u0000\u029f\u02a1\u0005e\u0000\u0000\u02a0\u029f\u0001\u0000\u0000"+
		"\u0000\u02a0\u02a1\u0001\u0000\u0000\u0000\u02a1\u02a2\u0001\u0000\u0000"+
		"\u0000\u02a2\u02a4\u0005V\u0000\u0000\u02a3\u0252\u0001\u0000\u0000\u0000"+
		"\u02a3\u025d\u0001\u0000\u0000\u0000\u02a3\u0268\u0001\u0000\u0000\u0000"+
		"\u02a3\u0273\u0001\u0000\u0000\u0000\u02a3\u027e\u0001\u0000\u0000\u0000"+
		"\u02a3\u0289\u0001\u0000\u0000\u0000\u02a3\u0294\u0001\u0000\u0000\u0000"+
		"\u02a3\u02a0\u0001\u0000\u0000\u0000\u02a41\u0001\u0000\u0000\u0000\u02a5"+
		"\u02a6\u0005M\u0000\u0000\u02a6\u02ab\u0005V\u0000\u0000\u02a7\u02a8\u0005"+
		"Q\u0000\u0000\u02a8\u02aa\u0005V\u0000\u0000\u02a9\u02a7\u0001\u0000\u0000"+
		"\u0000\u02aa\u02ad\u0001\u0000\u0000\u0000\u02ab\u02a9\u0001\u0000\u0000"+
		"\u0000\u02ab\u02ac\u0001\u0000\u0000\u0000\u02ac\u02ae\u0001\u0000\u0000"+
		"\u0000\u02ad\u02ab\u0001\u0000\u0000\u0000\u02ae\u02af\u0005N\u0000\u0000"+
		"\u02af3\u0001\u0000\u0000\u0000F6;DHUYw\u007f\u009a\u00ae\u00b0\u00b6"+
		"\u00c4\u00df\u00e2\u00e4\u00f1\u00f4\u00f6\u0103\u0106\u0108\u010b\u0114"+
		"\u0119\u0124\u012d\u0135\u0141\u0153\u015b\u015f\u0162\u016d\u017f\u018c"+
		"\u0190\u0194\u0196\u01a1\u01b3\u01bc\u01c0\u01c3\u01ce\u01e0\u01ea\u01ee"+
		"\u01f1\u01fc\u020e\u0218\u021c\u021f\u022a\u023c\u0245\u0249\u024d\u0250"+
		"\u0258\u0263\u026e\u0279\u0284\u028f\u029a\u02a0\u02a3\u02ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}