// Generated from D:/dev/git/dev-rune-tools/mathlogical-sentence-compiler/src/main/resources\MathematicalSentenceParserGrammar.g4 by ANTLR 4.9.2

    package io.github.mportilho.sentencecompiler.grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MathematicalSentenceParserGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, THEN=2, ELSE=3, ELSEIF=4, ENDIF=5, AND=6, OR=7, XOR=8, XNOR=9, NAND=10, 
		NOR=11, TRUE=12, FALSE=13, MULT=14, DIV=15, PLUS=16, MINUS=17, PERCENT=18, 
		MODULO=19, MODULUS=20, EXCLAMATION=21, EXPONENTIATION=22, ROOT=23, SQRT=24, 
		BINARY_LOGARITHM=25, NATURAL_LOGARITHM=26, COMMOM_LOGARITHM=27, LOGARITHM=28, 
		SUMMATION=29, PRODUCT_SEQUENCE=30, SUMMATION_VARIABLE=31, PRODUCT_SEQUENCE_VARIABLE=32, 
		MINUS_PARENTHESIS=33, SINE=34, COSINE=35, TANGENT=36, ARCSINE=37, ARCCOSINE=38, 
		ARCTANGENT=39, ARCTANGENT2=40, HYPERBOLIC_SINE=41, HYPERBOLIC_COSINE=42, 
		HYPERBOLIC_TANGENT=43, INVERSE_HYPERBOLIC_SINE=44, INVERSE_HYPERBOLIC_COSINE=45, 
		INVERSE_HYPERBOLIC_TANGENT=46, PI=47, EULER=48, DEGREE=49, GT=50, GE=51, 
		LT=52, LE=53, EQ=54, NEQ=55, NOT=56, R_UP=57, R_DOWN=58, R_CEILING=59, 
		R_FLOOR=60, R_HALF_UP=61, R_HALF_DOWN=62, R_HALF_EVEN=63, R_UNNECESSARY=64, 
		DATE_OPERATIONS=65, TIME_OPERATIONS=66, NOW_DATE=67, NOW_TIME=68, NOW_DATETIME=69, 
		PLUS_DAYS=70, PLUS_MONTHS=71, PLUS_YEARS=72, PLUS_HOURS=73, PLUS_MINUTES=74, 
		PLUS_SECONDS=75, MINUS_DAYS=76, MINUS_MONTHS=77, MINUS_YEARS=78, MINUS_HOURS=79, 
		MINUS_MINUTES=80, MINUS_SECONDS=81, SET_DAYS=82, SET_MONTHS=83, SET_YEARS=84, 
		SET_HOURS=85, SET_MINUTES=86, SET_SECONDS=87, LPAREN=88, RPAREN=89, LBLACKET=90, 
		RBLACKET=91, QUOTES=92, ASSIGNMENT=93, COMMA=94, SEMI=95, PERIOD=96, CONTAINS=97, 
		JSON_PATH=98, FUNCTION_PREFIX=99, NO_CACHE_FUNCTION_PREFIX=100, IDENTIFIER=101, 
		NEGATIVE_IDENTIFIER=102, STRING=103, NUMBER=104, POSITIVE=105, DATE=106, 
		TIME=107, DATETIME=108, BOOLEAN_TYPE=109, NUMBER_TYPE=110, STRING_TYPE=111, 
		DATE_TYPE=112, TIME_TYPE=113, DATETIME_TYPE=114, LIST_TYPE=115, ASSIGNABLE_TYPES=116, 
		DAY_PART=117, MONTH_PART=118, HOUR_PART=119, MINUTE_SECOND_PART=120, COMMENT=121, 
		WS=122;
	public static final int
		RULE_start = 0, RULE_mathStart = 1, RULE_logicalStart = 2, RULE_assignmentExpression = 3, 
		RULE_logicalExpression = 4, RULE_mathExpression = 5, RULE_logarithmFunction = 6, 
		RULE_roundingFunction = 7, RULE_sequenceFunction = 8, RULE_dateOperation = 9, 
		RULE_timeOperation = 10, RULE_dateTimeOperation = 11, RULE_function = 12, 
		RULE_listFunction = 13, RULE_comparisonOperator = 14, RULE_logicalOperator = 15, 
		RULE_allEntityTypes = 16, RULE_logicalEntity = 17, RULE_numericEntity = 18, 
		RULE_stringEntity = 19, RULE_dateEntity = 20, RULE_timeEntity = 21, RULE_dateTimeEntity = 22, 
		RULE_jsonPathExpression = 23, RULE_listEntity = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "mathStart", "logicalStart", "assignmentExpression", "logicalExpression", 
			"mathExpression", "logarithmFunction", "roundingFunction", "sequenceFunction", 
			"dateOperation", "timeOperation", "dateTimeOperation", "function", "listFunction", 
			"comparisonOperator", "logicalOperator", "allEntityTypes", "logicalEntity", 
			"numericEntity", "stringEntity", "dateEntity", "timeEntity", "dateTimeEntity", 
			"jsonPathExpression", "listEntity"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'then'", "'else'", "'elsif'", "'endif'", "'and'", "'or'", 
			"'xor'", "'xnor'", "'nand'", "'nor'", "'true'", "'false'", "'*'", "'/'", 
			"'+'", "'-'", "'%'", "'mod'", "'|'", "'!'", "'^'", null, "'sqrt'", "'lb'", 
			"'ln'", "'log10'", "'log'", "'S['", "'P['", "'S'", "'P'", null, "'sin'", 
			"'cos'", "'tan'", "'asin'", "'acos'", "'atan'", "'atan2'", "'sinh'", 
			"'cosh'", "'tanh'", "'asinh'", "'acosh'", "'atanh'", null, null, null, 
			"'>'", "'>='", "'<'", "'<='", "'='", null, null, "'up'", "'down'", "'ceiling'", 
			"'floor'", "'halfUp'", "'halfDown'", "'halfEven'", "'unnecessary'", null, 
			null, "'currDate'", "'currTime'", "'currDateTime'", "'plusDays'", "'plusMonths'", 
			"'plusYears'", "'plusHours'", "'plusMinutes'", "'plusSeconds'", "'minusDays'", 
			"'minusMonths'", "'minusYears'", "'minusHours'", "'minusMinutes'", "'minusSeconds'", 
			"'setDays'", "'setMonths'", "'setYears'", "'setHours'", "'setMinutes'", 
			"'setSeconds'", "'('", "')'", "'['", "']'", "'''", "':='", "','", "';'", 
			"'.'", "'contains'", null, "'f.'", "'f0.'", null, null, null, null, null, 
			null, null, null, "'<bool>'", "'<number>'", "'<text>'", "'<date>'", "'<time>'", 
			"'<datetime>'", "'<list>'"
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
			"MINUS_PARENTHESIS", "SINE", "COSINE", "TANGENT", "ARCSINE", "ARCCOSINE", 
			"ARCTANGENT", "ARCTANGENT2", "HYPERBOLIC_SINE", "HYPERBOLIC_COSINE", 
			"HYPERBOLIC_TANGENT", "INVERSE_HYPERBOLIC_SINE", "INVERSE_HYPERBOLIC_COSINE", 
			"INVERSE_HYPERBOLIC_TANGENT", "PI", "EULER", "DEGREE", "GT", "GE", "LT", 
			"LE", "EQ", "NEQ", "NOT", "R_UP", "R_DOWN", "R_CEILING", "R_FLOOR", "R_HALF_UP", 
			"R_HALF_DOWN", "R_HALF_EVEN", "R_UNNECESSARY", "DATE_OPERATIONS", "TIME_OPERATIONS", 
			"NOW_DATE", "NOW_TIME", "NOW_DATETIME", "PLUS_DAYS", "PLUS_MONTHS", "PLUS_YEARS", 
			"PLUS_HOURS", "PLUS_MINUTES", "PLUS_SECONDS", "MINUS_DAYS", "MINUS_MONTHS", 
			"MINUS_YEARS", "MINUS_HOURS", "MINUS_MINUTES", "MINUS_SECONDS", "SET_DAYS", 
			"SET_MONTHS", "SET_YEARS", "SET_HOURS", "SET_MINUTES", "SET_SECONDS", 
			"LPAREN", "RPAREN", "LBLACKET", "RBLACKET", "QUOTES", "ASSIGNMENT", "COMMA", 
			"SEMI", "PERIOD", "CONTAINS", "JSON_PATH", "FUNCTION_PREFIX", "NO_CACHE_FUNCTION_PREFIX", 
			"IDENTIFIER", "NEGATIVE_IDENTIFIER", "STRING", "NUMBER", "POSITIVE", 
			"DATE", "TIME", "DATETIME", "BOOLEAN_TYPE", "NUMBER_TYPE", "STRING_TYPE", 
			"DATE_TYPE", "TIME_TYPE", "DATETIME_TYPE", "LIST_TYPE", "ASSIGNABLE_TYPES", 
			"DAY_PART", "MONTH_PART", "HOUR_PART", "MINUTE_SECOND_PART", "COMMENT", 
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
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
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
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << TRUE) | (1L << FALSE) | (1L << MODULUS) | (1L << EXCLAMATION) | (1L << SQRT) | (1L << BINARY_LOGARITHM) | (1L << NATURAL_LOGARITHM) | (1L << COMMOM_LOGARITHM) | (1L << LOGARITHM) | (1L << SUMMATION) | (1L << PRODUCT_SEQUENCE) | (1L << SUMMATION_VARIABLE) | (1L << PRODUCT_SEQUENCE_VARIABLE) | (1L << MINUS_PARENTHESIS) | (1L << SINE) | (1L << COSINE) | (1L << TANGENT) | (1L << ARCSINE) | (1L << ARCCOSINE) | (1L << ARCTANGENT) | (1L << ARCTANGENT2) | (1L << HYPERBOLIC_SINE) | (1L << HYPERBOLIC_COSINE) | (1L << HYPERBOLIC_TANGENT) | (1L << INVERSE_HYPERBOLIC_SINE) | (1L << INVERSE_HYPERBOLIC_COSINE) | (1L << INVERSE_HYPERBOLIC_TANGENT) | (1L << PI) | (1L << EULER) | (1L << NOT) | (1L << R_UP) | (1L << R_DOWN) | (1L << R_CEILING) | (1L << R_FLOOR) | (1L << R_HALF_UP) | (1L << R_HALF_DOWN) | (1L << R_HALF_EVEN))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (R_UNNECESSARY - 64)) | (1L << (NOW_DATE - 64)) | (1L << (NOW_TIME - 64)) | (1L << (NOW_DATETIME - 64)) | (1L << (LPAREN - 64)) | (1L << (LBLACKET - 64)) | (1L << (FUNCTION_PREFIX - 64)) | (1L << (NO_CACHE_FUNCTION_PREFIX - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (NEGATIVE_IDENTIFIER - 64)) | (1L << (STRING - 64)) | (1L << (NUMBER - 64)) | (1L << (DATE - 64)) | (1L << (TIME - 64)) | (1L << (DATETIME - 64)) | (1L << (BOOLEAN_TYPE - 64)) | (1L << (NUMBER_TYPE - 64)) | (1L << (STRING_TYPE - 64)) | (1L << (DATE_TYPE - 64)) | (1L << (TIME_TYPE - 64)) | (1L << (DATETIME_TYPE - 64)) | (1L << (LIST_TYPE - 64)))) != 0)) {
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
	public static class AssignOperationContext extends AssignmentExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(MathematicalSentenceParserGrammarParser.ASSIGNMENT, 0); }
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

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignmentExpression);
		try {
			_localctx = new AssignOperationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(IDENTIFIER);
			setState(75);
			match(ASSIGNMENT);
			setState(76);
			allEntityTypes();
			setState(77);
			match(SEMI);
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
	public static class ListExpressionContext extends LogicalExpressionContext {
		public ListFunctionContext listFunction() {
			return getRuleContext(ListFunctionContext.class,0);
		}
		public ListExpressionContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListExpression(this);
			else return visitor.visitChildren(this);
		}
	}
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
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(80);
				_la = _input.LA(1);
				if ( !(_la==EXCLAMATION || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(81);
				logicalExpression(10);
				}
				break;
			case 2:
				{
				_localctx = new ComparisonMathExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				mathExpression(0);
				setState(83);
				comparisonOperator();
				setState(84);
				mathExpression(0);
				}
				break;
			case 3:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				stringEntity();
				setState(87);
				comparisonOperator();
				setState(88);
				stringEntity();
				}
				break;
			case 4:
				{
				_localctx = new DateExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				dateOperation();
				setState(91);
				comparisonOperator();
				setState(92);
				dateOperation();
				}
				break;
			case 5:
				{
				_localctx = new TimeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				timeOperation();
				setState(95);
				comparisonOperator();
				setState(96);
				timeOperation();
				}
				break;
			case 6:
				{
				_localctx = new DateTimeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				dateTimeOperation();
				setState(99);
				comparisonOperator();
				setState(100);
				dateTimeOperation();
				}
				break;
			case 7:
				{
				_localctx = new ListExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				listFunction();
				}
				break;
			case 8:
				{
				_localctx = new LogicalParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				match(LPAREN);
				setState(104);
				logicalExpression(0);
				setState(105);
				match(RPAREN);
				}
				break;
			case 9:
				{
				_localctx = new LogicalValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107);
				logicalEntity();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicExpressionContext(new LogicalExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
					setState(110);
					if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
					setState(111);
					logicalOperator();
					setState(112);
					logicalExpression(10);
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
	public static class InverseHyperbolicSineExpressionContext extends MathExpressionContext {
		public TerminalNode INVERSE_HYPERBOLIC_SINE() { return getToken(MathematicalSentenceParserGrammarParser.INVERSE_HYPERBOLIC_SINE, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public InverseHyperbolicSineExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterInverseHyperbolicSineExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitInverseHyperbolicSineExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitInverseHyperbolicSineExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SequenceExpressionContext extends MathExpressionContext {
		public SequenceFunctionContext sequenceFunction() {
			return getRuleContext(SequenceFunctionContext.class,0);
		}
		public SequenceExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
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
	public static class HyperbolicSineExpressionContext extends MathExpressionContext {
		public TerminalNode HYPERBOLIC_SINE() { return getToken(MathematicalSentenceParserGrammarParser.HYPERBOLIC_SINE, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public HyperbolicSineExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterHyperbolicSineExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitHyperbolicSineExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitHyperbolicSineExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InverseHyperbolicCosineExpressionContext extends MathExpressionContext {
		public TerminalNode INVERSE_HYPERBOLIC_COSINE() { return getToken(MathematicalSentenceParserGrammarParser.INVERSE_HYPERBOLIC_COSINE, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public InverseHyperbolicCosineExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterInverseHyperbolicCosineExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitInverseHyperbolicCosineExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitInverseHyperbolicCosineExpression(this);
			else return visitor.visitChildren(this);
		}
	}
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
	public static class TangentExpressionContext extends MathExpressionContext {
		public TerminalNode TANGENT() { return getToken(MathematicalSentenceParserGrammarParser.TANGENT, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public TangentExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterTangentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitTangentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitTangentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Arctangent2ExpressionContext extends MathExpressionContext {
		public TerminalNode ARCTANGENT2() { return getToken(MathematicalSentenceParserGrammarParser.ARCTANGENT2, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MathematicalSentenceParserGrammarParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public Arctangent2ExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterArctangent2Expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitArctangent2Expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitArctangent2Expression(this);
			else return visitor.visitChildren(this);
		}
	}
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
	public static class RoundingExpressionContext extends MathExpressionContext {
		public RoundingFunctionContext roundingFunction() {
			return getRuleContext(RoundingFunctionContext.class,0);
		}
		public RoundingExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
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
	public static class HyperbolicTangentExpressionContext extends MathExpressionContext {
		public TerminalNode HYPERBOLIC_TANGENT() { return getToken(MathematicalSentenceParserGrammarParser.HYPERBOLIC_TANGENT, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public HyperbolicTangentExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterHyperbolicTangentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitHyperbolicTangentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitHyperbolicTangentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HyperbolicCosineExpressionContext extends MathExpressionContext {
		public TerminalNode HYPERBOLIC_COSINE() { return getToken(MathematicalSentenceParserGrammarParser.HYPERBOLIC_COSINE, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public HyperbolicCosineExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterHyperbolicCosineExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitHyperbolicCosineExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitHyperbolicCosineExpression(this);
			else return visitor.visitChildren(this);
		}
	}
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
	public static class LogarithmExpressionContext extends MathExpressionContext {
		public LogarithmFunctionContext logarithmFunction() {
			return getRuleContext(LogarithmFunctionContext.class,0);
		}
		public LogarithmExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
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
	public static class SineExpressionContext extends MathExpressionContext {
		public TerminalNode SINE() { return getToken(MathematicalSentenceParserGrammarParser.SINE, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public SineExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterSineExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitSineExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitSineExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CosineExpressionContext extends MathExpressionContext {
		public TerminalNode COSINE() { return getToken(MathematicalSentenceParserGrammarParser.COSINE, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public CosineExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterCosineExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitCosineExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitCosineExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArctangentExpressionContext extends MathExpressionContext {
		public TerminalNode ARCTANGENT() { return getToken(MathematicalSentenceParserGrammarParser.ARCTANGENT, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public ArctangentExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterArctangentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitArctangentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitArctangentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
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
	public static class InverseHyperbolicTangentExpressionContext extends MathExpressionContext {
		public TerminalNode INVERSE_HYPERBOLIC_TANGENT() { return getToken(MathematicalSentenceParserGrammarParser.INVERSE_HYPERBOLIC_TANGENT, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public InverseHyperbolicTangentExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterInverseHyperbolicTangentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitInverseHyperbolicTangentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitInverseHyperbolicTangentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
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
	public static class ArccosineExpressionContext extends MathExpressionContext {
		public TerminalNode ARCCOSINE() { return getToken(MathematicalSentenceParserGrammarParser.ARCCOSINE, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public ArccosineExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterArccosineExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitArccosineExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitArccosineExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArcsineExpressionContext extends MathExpressionContext {
		public TerminalNode ARCSINE() { return getToken(MathematicalSentenceParserGrammarParser.ARCSINE, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public ArcsineExpressionContext(MathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterArcsineExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitArcsineExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitArcsineExpression(this);
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
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new MathParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(120);
				match(LPAREN);
				setState(121);
				mathExpression(0);
				setState(122);
				match(RPAREN);
				}
				break;
			case MINUS_PARENTHESIS:
				{
				_localctx = new NegateMathParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(MINUS_PARENTHESIS);
				setState(125);
				mathExpression(0);
				setState(126);
				match(RPAREN);
				}
				break;
			case SQRT:
				{
				_localctx = new SquareRootExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				match(SQRT);
				setState(129);
				match(LPAREN);
				setState(130);
				mathExpression(0);
				setState(131);
				match(RPAREN);
				}
				break;
			case MODULUS:
				{
				_localctx = new ModulusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				match(MODULUS);
				setState(134);
				mathExpression(0);
				setState(135);
				match(MODULUS);
				}
				break;
			case BINARY_LOGARITHM:
			case NATURAL_LOGARITHM:
			case COMMOM_LOGARITHM:
			case LOGARITHM:
				{
				_localctx = new LogarithmExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
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
				{
				_localctx = new RoundingExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				roundingFunction();
				}
				break;
			case SUMMATION:
			case PRODUCT_SEQUENCE:
				{
				_localctx = new SequenceExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				sequenceFunction();
				}
				break;
			case SINE:
				{
				_localctx = new SineExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(SINE);
				setState(141);
				match(LPAREN);
				setState(142);
				mathExpression(0);
				setState(143);
				match(RPAREN);
				}
				break;
			case COSINE:
				{
				_localctx = new CosineExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(COSINE);
				setState(146);
				match(LPAREN);
				setState(147);
				mathExpression(0);
				setState(148);
				match(RPAREN);
				}
				break;
			case TANGENT:
				{
				_localctx = new TangentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(TANGENT);
				setState(151);
				match(LPAREN);
				setState(152);
				mathExpression(0);
				setState(153);
				match(RPAREN);
				}
				break;
			case ARCSINE:
				{
				_localctx = new ArcsineExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				match(ARCSINE);
				setState(156);
				match(LPAREN);
				setState(157);
				mathExpression(0);
				setState(158);
				match(RPAREN);
				}
				break;
			case ARCCOSINE:
				{
				_localctx = new ArccosineExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				match(ARCCOSINE);
				setState(161);
				match(LPAREN);
				setState(162);
				mathExpression(0);
				setState(163);
				match(RPAREN);
				}
				break;
			case ARCTANGENT:
				{
				_localctx = new ArctangentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165);
				match(ARCTANGENT);
				setState(166);
				match(LPAREN);
				setState(167);
				mathExpression(0);
				setState(168);
				match(RPAREN);
				}
				break;
			case ARCTANGENT2:
				{
				_localctx = new Arctangent2ExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				match(ARCTANGENT2);
				setState(171);
				match(LPAREN);
				setState(172);
				mathExpression(0);
				setState(173);
				match(COMMA);
				setState(174);
				mathExpression(0);
				setState(175);
				match(RPAREN);
				}
				break;
			case HYPERBOLIC_SINE:
				{
				_localctx = new HyperbolicSineExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(HYPERBOLIC_SINE);
				setState(178);
				match(LPAREN);
				setState(179);
				mathExpression(0);
				setState(180);
				match(RPAREN);
				}
				break;
			case HYPERBOLIC_COSINE:
				{
				_localctx = new HyperbolicCosineExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				match(HYPERBOLIC_COSINE);
				setState(183);
				match(LPAREN);
				setState(184);
				mathExpression(0);
				setState(185);
				match(RPAREN);
				}
				break;
			case HYPERBOLIC_TANGENT:
				{
				_localctx = new HyperbolicTangentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(HYPERBOLIC_TANGENT);
				setState(188);
				match(LPAREN);
				setState(189);
				mathExpression(0);
				setState(190);
				match(RPAREN);
				}
				break;
			case INVERSE_HYPERBOLIC_SINE:
				{
				_localctx = new InverseHyperbolicSineExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(INVERSE_HYPERBOLIC_SINE);
				setState(193);
				match(LPAREN);
				setState(194);
				mathExpression(0);
				setState(195);
				match(RPAREN);
				}
				break;
			case INVERSE_HYPERBOLIC_COSINE:
				{
				_localctx = new InverseHyperbolicCosineExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(INVERSE_HYPERBOLIC_COSINE);
				setState(198);
				match(LPAREN);
				setState(199);
				mathExpression(0);
				setState(200);
				match(RPAREN);
				}
				break;
			case INVERSE_HYPERBOLIC_TANGENT:
				{
				_localctx = new InverseHyperbolicTangentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(INVERSE_HYPERBOLIC_TANGENT);
				setState(203);
				match(LPAREN);
				setState(204);
				mathExpression(0);
				setState(205);
				match(RPAREN);
				}
				break;
			case IF:
			case SUMMATION_VARIABLE:
			case PRODUCT_SEQUENCE_VARIABLE:
			case PI:
			case EULER:
			case FUNCTION_PREFIX:
			case NO_CACHE_FUNCTION_PREFIX:
			case IDENTIFIER:
			case NEGATIVE_IDENTIFIER:
			case NUMBER:
			case NUMBER_TYPE:
				{
				_localctx = new NumberValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				numericEntity();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(228);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new RootExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(210);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(211);
						match(ROOT);
						setState(212);
						mathExpression(25);
						}
						break;
					case 2:
						{
						_localctx = new ExponentiationExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(213);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(214);
						match(EXPONENTIATION);
						setState(215);
						mathExpression(22);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicationExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(216);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(217);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MODULO))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(218);
						mathExpression(22);
						}
						break;
					case 4:
						{
						_localctx = new SumExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(219);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(220);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						mathExpression(21);
						}
						break;
					case 5:
						{
						_localctx = new PercentExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(222);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(223);
						match(PERCENT);
						}
						break;
					case 6:
						{
						_localctx = new FactorialExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(224);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(225);
						match(EXCLAMATION);
						}
						break;
					case 7:
						{
						_localctx = new DegreeExpressionContext(new MathExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mathExpression);
						setState(226);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(227);
						match(DEGREE);
						}
						break;
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		enterRule(_localctx, 12, RULE_logarithmFunction);
		int _la;
		try {
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BINARY_LOGARITHM:
			case NATURAL_LOGARITHM:
			case COMMOM_LOGARITHM:
				_localctx = new FixedLogarithmContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BINARY_LOGARITHM) | (1L << NATURAL_LOGARITHM) | (1L << COMMOM_LOGARITHM))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(234);
				match(LPAREN);
				setState(235);
				mathExpression(0);
				setState(236);
				match(RPAREN);
				}
				break;
			case LOGARITHM:
				_localctx = new VariableLogarithmContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(LOGARITHM);
				setState(239);
				match(LPAREN);
				setState(240);
				mathExpression(0);
				setState(241);
				match(COMMA);
				setState(242);
				mathExpression(0);
				setState(243);
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
		enterRule(_localctx, 14, RULE_roundingFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_la = _input.LA(1);
			if ( !(((((_la - 57)) & ~0x3f) == 0 && ((1L << (_la - 57)) & ((1L << (R_UP - 57)) | (1L << (R_DOWN - 57)) | (1L << (R_CEILING - 57)) | (1L << (R_FLOOR - 57)) | (1L << (R_HALF_UP - 57)) | (1L << (R_HALF_DOWN - 57)) | (1L << (R_HALF_EVEN - 57)) | (1L << (R_UNNECESSARY - 57)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(248);
			match(LPAREN);
			setState(249);
			mathExpression(0);
			setState(250);
			match(COMMA);
			setState(251);
			mathExpression(0);
			setState(252);
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

	public static class SequenceFunctionContext extends ParserRuleContext {
		public List<MathExpressionContext> mathExpression() {
			return getRuleContexts(MathExpressionContext.class);
		}
		public MathExpressionContext mathExpression(int i) {
			return getRuleContext(MathExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MathematicalSentenceParserGrammarParser.COMMA, 0); }
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
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
		enterRule(_localctx, 16, RULE_sequenceFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_la = _input.LA(1);
			if ( !(_la==SUMMATION || _la==PRODUCT_SEQUENCE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(255);
			mathExpression(0);
			setState(256);
			match(COMMA);
			setState(257);
			mathExpression(0);
			setState(258);
			match(RBLACKET);
			setState(259);
			match(LPAREN);
			setState(260);
			mathExpression(0);
			setState(261);
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
		enterRule(_localctx, 18, RULE_dateOperation);
		try {
			int _alt;
			setState(279);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new DateParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				match(LPAREN);
				setState(264);
				dateOperation();
				setState(265);
				match(RPAREN);
				}
				break;
			case IF:
			case NOW_DATE:
			case FUNCTION_PREFIX:
			case NO_CACHE_FUNCTION_PREFIX:
			case IDENTIFIER:
			case DATE:
			case DATE_TYPE:
				_localctx = new DateFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				dateEntity();
				setState(277);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(268);
					match(DATE_OPERATIONS);
					setState(269);
					mathExpression(0);
					setState(274);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(270);
							match(DATE_OPERATIONS);
							setState(271);
							mathExpression(0);
							}
							} 
						}
						setState(276);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		enterRule(_localctx, 20, RULE_timeOperation);
		try {
			int _alt;
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new TimeParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				match(LPAREN);
				setState(282);
				timeOperation();
				setState(283);
				match(RPAREN);
				}
				break;
			case IF:
			case NOW_TIME:
			case FUNCTION_PREFIX:
			case NO_CACHE_FUNCTION_PREFIX:
			case IDENTIFIER:
			case TIME:
			case TIME_TYPE:
				_localctx = new TimeFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				timeEntity();
				setState(295);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(286);
					match(TIME_OPERATIONS);
					setState(287);
					mathExpression(0);
					setState(292);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(288);
							match(TIME_OPERATIONS);
							setState(289);
							mathExpression(0);
							}
							} 
						}
						setState(294);
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
		enterRule(_localctx, 22, RULE_dateTimeOperation);
		int _la;
		try {
			int _alt;
			setState(315);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new DateTimeParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				match(LPAREN);
				setState(300);
				dateTimeOperation();
				setState(301);
				match(RPAREN);
				}
				break;
			case IF:
			case NOW_DATETIME:
			case FUNCTION_PREFIX:
			case NO_CACHE_FUNCTION_PREFIX:
			case IDENTIFIER:
			case DATETIME:
			case DATETIME_TYPE:
				_localctx = new DateTimeFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				dateTimeEntity();
				setState(313);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(304);
					_la = _input.LA(1);
					if ( !(_la==DATE_OPERATIONS || _la==TIME_OPERATIONS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(305);
					mathExpression(0);
					setState(310);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(306);
							_la = _input.LA(1);
							if ( !(_la==DATE_OPERATIONS || _la==TIME_OPERATIONS) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							setState(307);
							mathExpression(0);
							}
							} 
						}
						setState(312);
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(MathematicalSentenceParserGrammarParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MathematicalSentenceParserGrammarParser.RPAREN, 0); }
		public TerminalNode FUNCTION_PREFIX() { return getToken(MathematicalSentenceParserGrammarParser.FUNCTION_PREFIX, 0); }
		public TerminalNode NO_CACHE_FUNCTION_PREFIX() { return getToken(MathematicalSentenceParserGrammarParser.NO_CACHE_FUNCTION_PREFIX, 0); }
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
		enterRule(_localctx, 24, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			_la = _input.LA(1);
			if ( !(_la==FUNCTION_PREFIX || _la==NO_CACHE_FUNCTION_PREFIX) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(318);
			match(IDENTIFIER);
			setState(319);
			match(LPAREN);
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << TRUE) | (1L << FALSE) | (1L << MODULUS) | (1L << EXCLAMATION) | (1L << SQRT) | (1L << BINARY_LOGARITHM) | (1L << NATURAL_LOGARITHM) | (1L << COMMOM_LOGARITHM) | (1L << LOGARITHM) | (1L << SUMMATION) | (1L << PRODUCT_SEQUENCE) | (1L << SUMMATION_VARIABLE) | (1L << PRODUCT_SEQUENCE_VARIABLE) | (1L << MINUS_PARENTHESIS) | (1L << SINE) | (1L << COSINE) | (1L << TANGENT) | (1L << ARCSINE) | (1L << ARCCOSINE) | (1L << ARCTANGENT) | (1L << ARCTANGENT2) | (1L << HYPERBOLIC_SINE) | (1L << HYPERBOLIC_COSINE) | (1L << HYPERBOLIC_TANGENT) | (1L << INVERSE_HYPERBOLIC_SINE) | (1L << INVERSE_HYPERBOLIC_COSINE) | (1L << INVERSE_HYPERBOLIC_TANGENT) | (1L << PI) | (1L << EULER) | (1L << NOT) | (1L << R_UP) | (1L << R_DOWN) | (1L << R_CEILING) | (1L << R_FLOOR) | (1L << R_HALF_UP) | (1L << R_HALF_DOWN) | (1L << R_HALF_EVEN))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (R_UNNECESSARY - 64)) | (1L << (NOW_DATE - 64)) | (1L << (NOW_TIME - 64)) | (1L << (NOW_DATETIME - 64)) | (1L << (LPAREN - 64)) | (1L << (LBLACKET - 64)) | (1L << (FUNCTION_PREFIX - 64)) | (1L << (NO_CACHE_FUNCTION_PREFIX - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (NEGATIVE_IDENTIFIER - 64)) | (1L << (STRING - 64)) | (1L << (NUMBER - 64)) | (1L << (DATE - 64)) | (1L << (TIME - 64)) | (1L << (DATETIME - 64)) | (1L << (BOOLEAN_TYPE - 64)) | (1L << (NUMBER_TYPE - 64)) | (1L << (STRING_TYPE - 64)) | (1L << (DATE_TYPE - 64)) | (1L << (TIME_TYPE - 64)) | (1L << (DATETIME_TYPE - 64)) | (1L << (LIST_TYPE - 64)))) != 0)) {
				{
				{
				setState(320);
				allEntityTypes();
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(321);
					match(COMMA);
					setState(322);
					allEntityTypes();
					}
					}
					setState(327);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(333);
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

	public static class ListFunctionContext extends ParserRuleContext {
		public ListFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listFunction; }
	 
		public ListFunctionContext() { }
		public void copyFrom(ListFunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ListContainsOperationContext extends ListFunctionContext {
		public ListEntityContext listEntity() {
			return getRuleContext(ListEntityContext.class,0);
		}
		public TerminalNode CONTAINS() { return getToken(MathematicalSentenceParserGrammarParser.CONTAINS, 0); }
		public AllEntityTypesContext allEntityTypes() {
			return getRuleContext(AllEntityTypesContext.class,0);
		}
		public ListContainsOperationContext(ListFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListContainsOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListContainsOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListContainsOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListFunctionContext listFunction() throws RecognitionException {
		ListFunctionContext _localctx = new ListFunctionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_listFunction);
		try {
			_localctx = new ListContainsOperationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			listEntity();
			setState(336);
			match(CONTAINS);
			setState(337);
			allEntityTypes();
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
			setState(339);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
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
			setState(345);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				match(AND);
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				match(OR);
				}
				break;
			case XOR:
			case XNOR:
			case NAND:
			case NOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(343);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << XOR) | (1L << XNOR) | (1L << NAND) | (1L << NOR))) != 0)) ) {
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
				setState(344);
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

	public static class AllEntityTypesContext extends ParserRuleContext {
		public StringEntityContext stringEntity() {
			return getRuleContext(StringEntityContext.class,0);
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
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public ListEntityContext listEntity() {
			return getRuleContext(ListEntityContext.class,0);
		}
		public JsonPathExpressionContext jsonPathExpression() {
			return getRuleContext(JsonPathExpressionContext.class,0);
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
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				stringEntity();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				dateOperation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(349);
				timeOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(350);
				dateTimeOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(351);
				logicalExpression(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(352);
				mathExpression(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(353);
				listEntity();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(354);
				jsonPathExpression();
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
	public static class LogicalJsonPathContext extends LogicalEntityContext {
		public JsonPathExpressionContext jsonPathExpression() {
			return getRuleContext(JsonPathExpressionContext.class,0);
		}
		public TerminalNode BOOLEAN_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.BOOLEAN_TYPE, 0); }
		public LogicalJsonPathContext(LogicalEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterLogicalJsonPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitLogicalJsonPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitLogicalJsonPath(this);
			else return visitor.visitChildren(this);
		}
	}
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

	public final LogicalEntityContext logicalEntity() throws RecognitionException {
		LogicalEntityContext _localctx = new LogicalEntityContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logicalEntity);
		int _la;
		try {
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new LogicalConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(357);
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
				setState(358);
				match(IF);
				setState(359);
				logicalExpression(0);
				setState(360);
				match(THEN);
				setState(361);
				logicalExpression(0);
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(362);
					match(ELSEIF);
					setState(363);
					logicalExpression(0);
					setState(364);
					match(THEN);
					setState(365);
					logicalExpression(0);
					}
				}

				setState(369);
				match(ELSE);
				setState(370);
				logicalExpression(0);
				setState(371);
				match(ENDIF);
				}
				break;
			case 3:
				_localctx = new LogicalJsonPathContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BOOLEAN_TYPE) {
					{
					setState(373);
					match(BOOLEAN_TYPE);
					}
				}

				setState(376);
				jsonPathExpression();
				}
				break;
			case 4:
				_localctx = new LogicalFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BOOLEAN_TYPE) {
					{
					setState(377);
					match(BOOLEAN_TYPE);
					}
				}

				setState(380);
				function();
				}
				break;
			case 5:
				_localctx = new LogicalVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BOOLEAN_TYPE) {
					{
					setState(381);
					match(BOOLEAN_TYPE);
					}
				}

				setState(384);
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
	public static class NumericJsonPathContext extends NumericEntityContext {
		public JsonPathExpressionContext jsonPathExpression() {
			return getRuleContext(JsonPathExpressionContext.class,0);
		}
		public TerminalNode NUMBER_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.NUMBER_TYPE, 0); }
		public NumericJsonPathContext(NumericEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterNumericJsonPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitNumericJsonPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitNumericJsonPath(this);
			else return visitor.visitChildren(this);
		}
	}
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
			setState(422);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new MathDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				match(IF);
				setState(388);
				logicalExpression(0);
				setState(389);
				match(THEN);
				setState(390);
				mathExpression(0);
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(391);
					match(ELSEIF);
					setState(392);
					logicalExpression(0);
					setState(393);
					match(THEN);
					setState(394);
					mathExpression(0);
					}
				}

				setState(398);
				match(ELSE);
				setState(399);
				mathExpression(0);
				setState(400);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new EulerConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				match(EULER);
				}
				break;
			case 3:
				_localctx = new PiConstantContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				match(PI);
				}
				break;
			case 4:
				_localctx = new SummationVariableContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(404);
				match(SUMMATION_VARIABLE);
				}
				break;
			case 5:
				_localctx = new ProductSequenceVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(405);
				match(PRODUCT_SEQUENCE_VARIABLE);
				}
				break;
			case 6:
				_localctx = new NumericConstantContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(406);
				match(NUMBER);
				}
				break;
			case 7:
				_localctx = new NumericJsonPathContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER_TYPE) {
					{
					setState(407);
					match(NUMBER_TYPE);
					}
				}

				setState(410);
				jsonPathExpression();
				}
				break;
			case 8:
				_localctx = new NumericFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(412);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER_TYPE) {
					{
					setState(411);
					match(NUMBER_TYPE);
					}
				}

				setState(414);
				function();
				}
				break;
			case 9:
				_localctx = new NumericVariableContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(420);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
				case NUMBER_TYPE:
					{
					setState(416);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NUMBER_TYPE) {
						{
						setState(415);
						match(NUMBER_TYPE);
						}
					}

					setState(418);
					match(IDENTIFIER);
					}
					break;
				case NEGATIVE_IDENTIFIER:
					{
					setState(419);
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
	public static class StringJsonPathContext extends StringEntityContext {
		public JsonPathExpressionContext jsonPathExpression() {
			return getRuleContext(JsonPathExpressionContext.class,0);
		}
		public TerminalNode STRING_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.STRING_TYPE, 0); }
		public StringJsonPathContext(StringEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterStringJsonPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitStringJsonPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitStringJsonPath(this);
			else return visitor.visitChildren(this);
		}
	}
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
			setState(452);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				_localctx = new StringDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				match(IF);
				setState(425);
				logicalExpression(0);
				setState(426);
				match(THEN);
				setState(427);
				stringEntity();
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(428);
					match(ELSEIF);
					setState(429);
					logicalExpression(0);
					setState(430);
					match(THEN);
					setState(431);
					stringEntity();
					}
				}

				setState(435);
				match(ELSE);
				setState(436);
				stringEntity();
				setState(437);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new StringConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(439);
				match(STRING);
				}
				break;
			case 3:
				_localctx = new StringJsonPathContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING_TYPE) {
					{
					setState(440);
					match(STRING_TYPE);
					}
				}

				setState(443);
				jsonPathExpression();
				}
				break;
			case 4:
				_localctx = new StringFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING_TYPE) {
					{
					setState(444);
					match(STRING_TYPE);
					}
				}

				setState(447);
				function();
				}
				break;
			case 5:
				_localctx = new StringVariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING_TYPE) {
					{
					setState(448);
					match(STRING_TYPE);
					}
				}

				setState(451);
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
	public static class DateJsonPathContext extends DateEntityContext {
		public JsonPathExpressionContext jsonPathExpression() {
			return getRuleContext(JsonPathExpressionContext.class,0);
		}
		public TerminalNode DATE_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.DATE_TYPE, 0); }
		public DateJsonPathContext(DateEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateJsonPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateJsonPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateJsonPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateEntityContext dateEntity() throws RecognitionException {
		DateEntityContext _localctx = new DateEntityContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_dateEntity);
		int _la;
		try {
			setState(483);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				_localctx = new DateDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				match(IF);
				setState(455);
				logicalExpression(0);
				setState(456);
				match(THEN);
				setState(457);
				dateOperation();
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(458);
					match(ELSEIF);
					setState(459);
					logicalExpression(0);
					setState(460);
					match(THEN);
					setState(461);
					dateOperation();
					}
				}

				setState(465);
				match(ELSE);
				setState(466);
				dateOperation();
				setState(467);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new DateConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(469);
				match(DATE);
				}
				break;
			case 3:
				_localctx = new DateCurrentValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(470);
				match(NOW_DATE);
				}
				break;
			case 4:
				_localctx = new DateVariableContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATE_TYPE) {
					{
					setState(471);
					match(DATE_TYPE);
					}
				}

				setState(474);
				match(IDENTIFIER);
				}
				break;
			case 5:
				_localctx = new DateFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATE_TYPE) {
					{
					setState(475);
					match(DATE_TYPE);
					}
				}

				setState(478);
				function();
				}
				break;
			case 6:
				_localctx = new DateJsonPathContext(_localctx);
				enterOuterAlt(_localctx, 6);
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
				jsonPathExpression();
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
	public static class TimeJsonPathContext extends TimeEntityContext {
		public JsonPathExpressionContext jsonPathExpression() {
			return getRuleContext(JsonPathExpressionContext.class,0);
		}
		public TerminalNode TIME_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.TIME_TYPE, 0); }
		public TimeJsonPathContext(TimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterTimeJsonPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitTimeJsonPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitTimeJsonPath(this);
			else return visitor.visitChildren(this);
		}
	}
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
			setState(514);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				_localctx = new TimeDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(485);
				match(IF);
				setState(486);
				logicalExpression(0);
				setState(487);
				match(THEN);
				setState(488);
				timeOperation();
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(489);
					match(ELSEIF);
					setState(490);
					logicalExpression(0);
					setState(491);
					match(THEN);
					setState(492);
					timeOperation();
					}
				}

				setState(496);
				match(ELSE);
				setState(497);
				timeOperation();
				setState(498);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new TimeConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				match(TIME);
				}
				break;
			case 3:
				_localctx = new TimeCurrentValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(501);
				match(NOW_TIME);
				}
				break;
			case 4:
				_localctx = new TimeVariableContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TIME_TYPE) {
					{
					setState(502);
					match(TIME_TYPE);
					}
				}

				setState(505);
				match(IDENTIFIER);
				}
				break;
			case 5:
				_localctx = new TimeFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TIME_TYPE) {
					{
					setState(506);
					match(TIME_TYPE);
					}
				}

				setState(509);
				function();
				}
				break;
			case 6:
				_localctx = new TimeJsonPathContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(511);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TIME_TYPE) {
					{
					setState(510);
					match(TIME_TYPE);
					}
				}

				setState(513);
				jsonPathExpression();
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
	public static class DateTimeJsonPathContext extends DateTimeEntityContext {
		public JsonPathExpressionContext jsonPathExpression() {
			return getRuleContext(JsonPathExpressionContext.class,0);
		}
		public TerminalNode DATETIME_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.DATETIME_TYPE, 0); }
		public DateTimeJsonPathContext(DateTimeEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterDateTimeJsonPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitDateTimeJsonPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitDateTimeJsonPath(this);
			else return visitor.visitChildren(this);
		}
	}
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

	public final DateTimeEntityContext dateTimeEntity() throws RecognitionException {
		DateTimeEntityContext _localctx = new DateTimeEntityContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_dateTimeEntity);
		int _la;
		try {
			setState(545);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				_localctx = new DateTimeDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				match(IF);
				setState(517);
				logicalExpression(0);
				setState(518);
				match(THEN);
				setState(519);
				dateTimeOperation();
				setState(525);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(520);
					match(ELSEIF);
					setState(521);
					logicalExpression(0);
					setState(522);
					match(THEN);
					setState(523);
					dateTimeOperation();
					}
				}

				setState(527);
				match(ELSE);
				setState(528);
				dateTimeOperation();
				setState(529);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new DateTimeConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(531);
				match(DATETIME);
				}
				break;
			case 3:
				_localctx = new DateTimeCurrentValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(532);
				match(NOW_DATETIME);
				}
				break;
			case 4:
				_localctx = new DateTimeVariableContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(534);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATETIME_TYPE) {
					{
					setState(533);
					match(DATETIME_TYPE);
					}
				}

				setState(536);
				match(IDENTIFIER);
				}
				break;
			case 5:
				_localctx = new DateTimeFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATETIME_TYPE) {
					{
					setState(537);
					match(DATETIME_TYPE);
					}
				}

				setState(540);
				function();
				}
				break;
			case 6:
				_localctx = new DateTimeJsonPathContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DATETIME_TYPE) {
					{
					setState(541);
					match(DATETIME_TYPE);
					}
				}

				setState(544);
				jsonPathExpression();
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

	public static class JsonPathExpressionContext extends ParserRuleContext {
		public JsonPathExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonPathExpression; }
	 
		public JsonPathExpressionContext() { }
		public void copyFrom(JsonPathExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class JsonPathValueContext extends JsonPathExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public TerminalNode JSON_PATH() { return getToken(MathematicalSentenceParserGrammarParser.JSON_PATH, 0); }
		public JsonPathValueContext(JsonPathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterJsonPathValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitJsonPathValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitJsonPathValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JsonPathDecisionExpressionContext extends JsonPathExpressionContext {
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
		public List<JsonPathExpressionContext> jsonPathExpression() {
			return getRuleContexts(JsonPathExpressionContext.class);
		}
		public JsonPathExpressionContext jsonPathExpression(int i) {
			return getRuleContext(JsonPathExpressionContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MathematicalSentenceParserGrammarParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(MathematicalSentenceParserGrammarParser.ENDIF, 0); }
		public TerminalNode ELSEIF() { return getToken(MathematicalSentenceParserGrammarParser.ELSEIF, 0); }
		public JsonPathDecisionExpressionContext(JsonPathExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterJsonPathDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitJsonPathDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitJsonPathDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonPathExpressionContext jsonPathExpression() throws RecognitionException {
		JsonPathExpressionContext _localctx = new JsonPathExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_jsonPathExpression);
		int _la;
		try {
			setState(564);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new JsonPathDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(547);
				match(IF);
				setState(548);
				logicalExpression(0);
				setState(549);
				match(THEN);
				setState(550);
				jsonPathExpression();
				setState(556);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(551);
					match(ELSEIF);
					setState(552);
					logicalExpression(0);
					setState(553);
					match(THEN);
					setState(554);
					jsonPathExpression();
					}
				}

				setState(558);
				match(ELSE);
				setState(559);
				jsonPathExpression();
				setState(560);
				match(ENDIF);
				}
				break;
			case IDENTIFIER:
				_localctx = new JsonPathValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(562);
				match(IDENTIFIER);
				setState(563);
				match(JSON_PATH);
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

	public static class ListEntityContext extends ParserRuleContext {
		public ListEntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listEntity; }
	 
		public ListEntityContext() { }
		public void copyFrom(ListEntityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ListDecisionExpressionContext extends ListEntityContext {
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
		public List<ListFunctionContext> listFunction() {
			return getRuleContexts(ListFunctionContext.class);
		}
		public ListFunctionContext listFunction(int i) {
			return getRuleContext(ListFunctionContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MathematicalSentenceParserGrammarParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(MathematicalSentenceParserGrammarParser.ENDIF, 0); }
		public TerminalNode ELSEIF() { return getToken(MathematicalSentenceParserGrammarParser.ELSEIF, 0); }
		public ListDecisionExpressionContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListDecisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListDecisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListDecisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListOfStringsContext extends ListEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<TerminalNode> STRING() { return getTokens(MathematicalSentenceParserGrammarParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.STRING, i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public ListOfStringsContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListOfStrings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListOfStrings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListOfStrings(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListOfVariablesContext extends ListEntityContext {
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
		public ListOfVariablesContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListOfVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListOfVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListOfVariables(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListVariableContext extends ListEntityContext {
		public TerminalNode LIST_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.LIST_TYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MathematicalSentenceParserGrammarParser.IDENTIFIER, 0); }
		public ListVariableContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListFromJsonPathContext extends ListEntityContext {
		public TerminalNode LIST_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.LIST_TYPE, 0); }
		public JsonPathExpressionContext jsonPathExpression() {
			return getRuleContext(JsonPathExpressionContext.class,0);
		}
		public ListFromJsonPathContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListFromJsonPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListFromJsonPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListFromJsonPath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListOfFunctionResultContext extends ListEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public ListOfFunctionResultContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListOfFunctionResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListOfFunctionResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListOfFunctionResult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListOfNumbersContext extends ListEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(MathematicalSentenceParserGrammarParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.NUMBER, i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public ListOfNumbersContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListOfNumbers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListOfNumbers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListOfNumbers(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListOfJsonPathContext extends ListEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<JsonPathExpressionContext> jsonPathExpression() {
			return getRuleContexts(JsonPathExpressionContext.class);
		}
		public JsonPathExpressionContext jsonPathExpression(int i) {
			return getRuleContext(JsonPathExpressionContext.class,i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public ListOfJsonPathContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListOfJsonPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListOfJsonPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListOfJsonPath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListOfDateTimesContext extends ListEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<TerminalNode> DATETIME() { return getTokens(MathematicalSentenceParserGrammarParser.DATETIME); }
		public TerminalNode DATETIME(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.DATETIME, i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public ListOfDateTimesContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListOfDateTimes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListOfDateTimes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListOfDateTimes(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListOfBooleansContext extends ListEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> TRUE() { return getTokens(MathematicalSentenceParserGrammarParser.TRUE); }
		public TerminalNode TRUE(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.TRUE, i);
		}
		public List<TerminalNode> FALSE() { return getTokens(MathematicalSentenceParserGrammarParser.FALSE); }
		public TerminalNode FALSE(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.FALSE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public ListOfBooleansContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListOfBooleans(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListOfBooleans(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListOfBooleans(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListOfDatesContext extends ListEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<TerminalNode> DATE() { return getTokens(MathematicalSentenceParserGrammarParser.DATE); }
		public TerminalNode DATE(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.DATE, i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public ListOfDatesContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListOfDates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListOfDates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListOfDates(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListFromFunctionContext extends ListEntityContext {
		public TerminalNode LIST_TYPE() { return getToken(MathematicalSentenceParserGrammarParser.LIST_TYPE, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ListFromFunctionContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListFromFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListFromFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListFromFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListOfTimesContext extends ListEntityContext {
		public TerminalNode LBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.LBLACKET, 0); }
		public List<TerminalNode> TIME() { return getTokens(MathematicalSentenceParserGrammarParser.TIME); }
		public TerminalNode TIME(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.TIME, i);
		}
		public TerminalNode RBLACKET() { return getToken(MathematicalSentenceParserGrammarParser.RBLACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MathematicalSentenceParserGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MathematicalSentenceParserGrammarParser.COMMA, i);
		}
		public ListOfTimesContext(ListEntityContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).enterListOfTimes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MathematicalSentenceParserGrammarListener ) ((MathematicalSentenceParserGrammarListener)listener).exitListOfTimes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MathematicalSentenceParserGrammarVisitor ) return ((MathematicalSentenceParserGrammarVisitor<? extends T>)visitor).visitListOfTimes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListEntityContext listEntity() throws RecognitionException {
		ListEntityContext _localctx = new ListEntityContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_listEntity);
		int _la;
		try {
			setState(672);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				_localctx = new ListDecisionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(566);
				match(IF);
				setState(567);
				logicalExpression(0);
				setState(568);
				match(THEN);
				setState(569);
				listFunction();
				setState(575);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSEIF) {
					{
					setState(570);
					match(ELSEIF);
					setState(571);
					logicalExpression(0);
					setState(572);
					match(THEN);
					setState(573);
					listFunction();
					}
				}

				setState(577);
				match(ELSE);
				setState(578);
				listFunction();
				setState(579);
				match(ENDIF);
				}
				break;
			case 2:
				_localctx = new ListOfNumbersContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(581);
				match(LBLACKET);
				setState(582);
				match(NUMBER);
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(583);
					match(COMMA);
					setState(584);
					match(NUMBER);
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
			case 3:
				_localctx = new ListOfBooleansContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(591);
				match(LBLACKET);
				setState(592);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(597);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(593);
					match(COMMA);
					setState(594);
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
					}
					setState(599);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(600);
				match(RBLACKET);
				}
				break;
			case 4:
				_localctx = new ListOfStringsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(601);
				match(LBLACKET);
				setState(602);
				match(STRING);
				setState(607);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(603);
					match(COMMA);
					setState(604);
					match(STRING);
					}
					}
					setState(609);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(610);
				match(RBLACKET);
				}
				break;
			case 5:
				_localctx = new ListOfDatesContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(611);
				match(LBLACKET);
				setState(612);
				match(DATE);
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(613);
					match(COMMA);
					setState(614);
					match(DATE);
					}
					}
					setState(619);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(620);
				match(RBLACKET);
				}
				break;
			case 6:
				_localctx = new ListOfTimesContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(621);
				match(LBLACKET);
				setState(622);
				match(TIME);
				setState(627);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(623);
					match(COMMA);
					setState(624);
					match(TIME);
					}
					}
					setState(629);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(630);
				match(RBLACKET);
				}
				break;
			case 7:
				_localctx = new ListOfDateTimesContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(631);
				match(LBLACKET);
				setState(632);
				match(DATETIME);
				setState(637);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(633);
					match(COMMA);
					setState(634);
					match(DATETIME);
					}
					}
					setState(639);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(640);
				match(RBLACKET);
				}
				break;
			case 8:
				_localctx = new ListOfVariablesContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(641);
				match(LBLACKET);
				setState(642);
				match(IDENTIFIER);
				setState(647);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(643);
					match(COMMA);
					setState(644);
					match(IDENTIFIER);
					}
					}
					setState(649);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(650);
				match(RBLACKET);
				}
				break;
			case 9:
				_localctx = new ListOfJsonPathContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(651);
				match(LBLACKET);
				setState(652);
				jsonPathExpression();
				setState(657);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(653);
					match(COMMA);
					setState(654);
					jsonPathExpression();
					}
					}
					setState(659);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(660);
				match(RBLACKET);
				}
				break;
			case 10:
				_localctx = new ListOfFunctionResultContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(662);
				match(LBLACKET);
				setState(663);
				function();
				setState(664);
				match(RBLACKET);
				}
				break;
			case 11:
				_localctx = new ListFromFunctionContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(666);
				match(LIST_TYPE);
				setState(667);
				function();
				}
				break;
			case 12:
				_localctx = new ListFromJsonPathContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(668);
				match(LIST_TYPE);
				setState(669);
				jsonPathExpression();
				}
				break;
			case 13:
				_localctx = new ListVariableContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(670);
				match(LIST_TYPE);
				setState(671);
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
			return precpred(_ctx, 9);
		}
		return true;
	}
	private boolean mathExpression_sempred(MathExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 24);
		case 2:
			return precpred(_ctx, 22);
		case 3:
			return precpred(_ctx, 21);
		case 4:
			return precpred(_ctx, 20);
		case 5:
			return precpred(_ctx, 26);
		case 6:
			return precpred(_ctx, 25);
		case 7:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3|\u02a5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\5\2\67\n\2\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\3\3\3\3"+
		"\3\4\7\4C\n\4\f\4\16\4F\13\4\3\4\5\4I\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6o\n\6\3\6\3\6\3\6\3"+
		"\6\7\6u\n\6\f\6\16\6x\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00d3\n\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00e7\n\7\f\7\16"+
		"\7\u00ea\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00f8"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0113\n\13\f\13\16\13"+
		"\u0116\13\13\5\13\u0118\n\13\5\13\u011a\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\7\f\u0125\n\f\f\f\16\f\u0128\13\f\5\f\u012a\n\f\5\f\u012c\n"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0137\n\r\f\r\16\r\u013a\13"+
		"\r\5\r\u013c\n\r\5\r\u013e\n\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0146"+
		"\n\16\f\16\16\16\u0149\13\16\7\16\u014b\n\16\f\16\16\16\u014e\13\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u015c"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0166\n\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0172\n\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u0179\n\23\3\23\3\23\5\23\u017d\n\23\3\23\3\23\5\23\u0181"+
		"\n\23\3\23\5\23\u0184\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u018f\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u019b\n\24\3\24\3\24\5\24\u019f\n\24\3\24\3\24\5\24\u01a3\n\24\3\24\3"+
		"\24\5\24\u01a7\n\24\5\24\u01a9\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u01b4\n\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u01bc\n"+
		"\25\3\25\3\25\5\25\u01c0\n\25\3\25\3\25\5\25\u01c4\n\25\3\25\5\25\u01c7"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01d2\n\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01db\n\26\3\26\3\26\5\26\u01df\n"+
		"\26\3\26\3\26\5\26\u01e3\n\26\3\26\5\26\u01e6\n\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u01f1\n\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u01fa\n\27\3\27\3\27\5\27\u01fe\n\27\3\27\3\27\5\27\u0202\n"+
		"\27\3\27\5\27\u0205\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0210\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0219\n\30\3"+
		"\30\3\30\5\30\u021d\n\30\3\30\3\30\5\30\u0221\n\30\3\30\5\30\u0224\n\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u022f\n\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u0237\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u0242\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32"+
		"\u024c\n\32\f\32\16\32\u024f\13\32\3\32\3\32\3\32\3\32\3\32\7\32\u0256"+
		"\n\32\f\32\16\32\u0259\13\32\3\32\3\32\3\32\3\32\3\32\7\32\u0260\n\32"+
		"\f\32\16\32\u0263\13\32\3\32\3\32\3\32\3\32\3\32\7\32\u026a\n\32\f\32"+
		"\16\32\u026d\13\32\3\32\3\32\3\32\3\32\3\32\7\32\u0274\n\32\f\32\16\32"+
		"\u0277\13\32\3\32\3\32\3\32\3\32\3\32\7\32\u027e\n\32\f\32\16\32\u0281"+
		"\13\32\3\32\3\32\3\32\3\32\3\32\7\32\u0288\n\32\f\32\16\32\u028b\13\32"+
		"\3\32\3\32\3\32\3\32\3\32\7\32\u0292\n\32\f\32\16\32\u0295\13\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u02a3\n\32"+
		"\3\32\2\4\n\f\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\2\16\4\2\27\27::\4\2\20\21\25\25\3\2\22\23\3\2\33\35\3\2;B\3\2\37 \3"+
		"\2CD\3\2ef\3\2\649\3\2\n\r\3\289\3\2\16\17\2\u0318\2\66\3\2\2\2\4;\3\2"+
		"\2\2\6D\3\2\2\2\bL\3\2\2\2\nn\3\2\2\2\f\u00d2\3\2\2\2\16\u00f7\3\2\2\2"+
		"\20\u00f9\3\2\2\2\22\u0100\3\2\2\2\24\u0119\3\2\2\2\26\u012b\3\2\2\2\30"+
		"\u013d\3\2\2\2\32\u013f\3\2\2\2\34\u0151\3\2\2\2\36\u0155\3\2\2\2 \u015b"+
		"\3\2\2\2\"\u0165\3\2\2\2$\u0183\3\2\2\2&\u01a8\3\2\2\2(\u01c6\3\2\2\2"+
		"*\u01e5\3\2\2\2,\u0204\3\2\2\2.\u0223\3\2\2\2\60\u0236\3\2\2\2\62\u02a2"+
		"\3\2\2\2\64\67\5\4\3\2\65\67\5\6\4\2\66\64\3\2\2\2\66\65\3\2\2\2\67\3"+
		"\3\2\2\28:\5\b\5\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2="+
		";\3\2\2\2>?\5\f\7\2?@\7\2\2\3@\5\3\2\2\2AC\5\b\5\2BA\3\2\2\2CF\3\2\2\2"+
		"DB\3\2\2\2DE\3\2\2\2EH\3\2\2\2FD\3\2\2\2GI\5\n\6\2HG\3\2\2\2HI\3\2\2\2"+
		"IJ\3\2\2\2JK\7\2\2\3K\7\3\2\2\2LM\7g\2\2MN\7_\2\2NO\5\"\22\2OP\7a\2\2"+
		"P\t\3\2\2\2QR\b\6\1\2RS\t\2\2\2So\5\n\6\fTU\5\f\7\2UV\5\36\20\2VW\5\f"+
		"\7\2Wo\3\2\2\2XY\5(\25\2YZ\5\36\20\2Z[\5(\25\2[o\3\2\2\2\\]\5\24\13\2"+
		"]^\5\36\20\2^_\5\24\13\2_o\3\2\2\2`a\5\26\f\2ab\5\36\20\2bc\5\26\f\2c"+
		"o\3\2\2\2de\5\30\r\2ef\5\36\20\2fg\5\30\r\2go\3\2\2\2ho\5\34\17\2ij\7"+
		"Z\2\2jk\5\n\6\2kl\7[\2\2lo\3\2\2\2mo\5$\23\2nQ\3\2\2\2nT\3\2\2\2nX\3\2"+
		"\2\2n\\\3\2\2\2n`\3\2\2\2nd\3\2\2\2nh\3\2\2\2ni\3\2\2\2nm\3\2\2\2ov\3"+
		"\2\2\2pq\f\13\2\2qr\5 \21\2rs\5\n\6\fsu\3\2\2\2tp\3\2\2\2ux\3\2\2\2vt"+
		"\3\2\2\2vw\3\2\2\2w\13\3\2\2\2xv\3\2\2\2yz\b\7\1\2z{\7Z\2\2{|\5\f\7\2"+
		"|}\7[\2\2}\u00d3\3\2\2\2~\177\7#\2\2\177\u0080\5\f\7\2\u0080\u0081\7["+
		"\2\2\u0081\u00d3\3\2\2\2\u0082\u0083\7\32\2\2\u0083\u0084\7Z\2\2\u0084"+
		"\u0085\5\f\7\2\u0085\u0086\7[\2\2\u0086\u00d3\3\2\2\2\u0087\u0088\7\26"+
		"\2\2\u0088\u0089\5\f\7\2\u0089\u008a\7\26\2\2\u008a\u00d3\3\2\2\2\u008b"+
		"\u00d3\5\16\b\2\u008c\u00d3\5\20\t\2\u008d\u00d3\5\22\n\2\u008e\u008f"+
		"\7$\2\2\u008f\u0090\7Z\2\2\u0090\u0091\5\f\7\2\u0091\u0092\7[\2\2\u0092"+
		"\u00d3\3\2\2\2\u0093\u0094\7%\2\2\u0094\u0095\7Z\2\2\u0095\u0096\5\f\7"+
		"\2\u0096\u0097\7[\2\2\u0097\u00d3\3\2\2\2\u0098\u0099\7&\2\2\u0099\u009a"+
		"\7Z\2\2\u009a\u009b\5\f\7\2\u009b\u009c\7[\2\2\u009c\u00d3\3\2\2\2\u009d"+
		"\u009e\7\'\2\2\u009e\u009f\7Z\2\2\u009f\u00a0\5\f\7\2\u00a0\u00a1\7[\2"+
		"\2\u00a1\u00d3\3\2\2\2\u00a2\u00a3\7(\2\2\u00a3\u00a4\7Z\2\2\u00a4\u00a5"+
		"\5\f\7\2\u00a5\u00a6\7[\2\2\u00a6\u00d3\3\2\2\2\u00a7\u00a8\7)\2\2\u00a8"+
		"\u00a9\7Z\2\2\u00a9\u00aa\5\f\7\2\u00aa\u00ab\7[\2\2\u00ab\u00d3\3\2\2"+
		"\2\u00ac\u00ad\7*\2\2\u00ad\u00ae\7Z\2\2\u00ae\u00af\5\f\7\2\u00af\u00b0"+
		"\7`\2\2\u00b0\u00b1\5\f\7\2\u00b1\u00b2\7[\2\2\u00b2\u00d3\3\2\2\2\u00b3"+
		"\u00b4\7+\2\2\u00b4\u00b5\7Z\2\2\u00b5\u00b6\5\f\7\2\u00b6\u00b7\7[\2"+
		"\2\u00b7\u00d3\3\2\2\2\u00b8\u00b9\7,\2\2\u00b9\u00ba\7Z\2\2\u00ba\u00bb"+
		"\5\f\7\2\u00bb\u00bc\7[\2\2\u00bc\u00d3\3\2\2\2\u00bd\u00be\7-\2\2\u00be"+
		"\u00bf\7Z\2\2\u00bf\u00c0\5\f\7\2\u00c0\u00c1\7[\2\2\u00c1\u00d3\3\2\2"+
		"\2\u00c2\u00c3\7.\2\2\u00c3\u00c4\7Z\2\2\u00c4\u00c5\5\f\7\2\u00c5\u00c6"+
		"\7[\2\2\u00c6\u00d3\3\2\2\2\u00c7\u00c8\7/\2\2\u00c8\u00c9\7Z\2\2\u00c9"+
		"\u00ca\5\f\7\2\u00ca\u00cb\7[\2\2\u00cb\u00d3\3\2\2\2\u00cc\u00cd\7\60"+
		"\2\2\u00cd\u00ce\7Z\2\2\u00ce\u00cf\5\f\7\2\u00cf\u00d0\7[\2\2\u00d0\u00d3"+
		"\3\2\2\2\u00d1\u00d3\5&\24\2\u00d2y\3\2\2\2\u00d2~\3\2\2\2\u00d2\u0082"+
		"\3\2\2\2\u00d2\u0087\3\2\2\2\u00d2\u008b\3\2\2\2\u00d2\u008c\3\2\2\2\u00d2"+
		"\u008d\3\2\2\2\u00d2\u008e\3\2\2\2\u00d2\u0093\3\2\2\2\u00d2\u0098\3\2"+
		"\2\2\u00d2\u009d\3\2\2\2\u00d2\u00a2\3\2\2\2\u00d2\u00a7\3\2\2\2\u00d2"+
		"\u00ac\3\2\2\2\u00d2\u00b3\3\2\2\2\u00d2\u00b8\3\2\2\2\u00d2\u00bd\3\2"+
		"\2\2\u00d2\u00c2\3\2\2\2\u00d2\u00c7\3\2\2\2\u00d2\u00cc\3\2\2\2\u00d2"+
		"\u00d1\3\2\2\2\u00d3\u00e8\3\2\2\2\u00d4\u00d5\f\32\2\2\u00d5\u00d6\7"+
		"\31\2\2\u00d6\u00e7\5\f\7\33\u00d7\u00d8\f\30\2\2\u00d8\u00d9\7\30\2\2"+
		"\u00d9\u00e7\5\f\7\30\u00da\u00db\f\27\2\2\u00db\u00dc\t\3\2\2\u00dc\u00e7"+
		"\5\f\7\30\u00dd\u00de\f\26\2\2\u00de\u00df\t\4\2\2\u00df\u00e7\5\f\7\27"+
		"\u00e0\u00e1\f\34\2\2\u00e1\u00e7\7\24\2\2\u00e2\u00e3\f\33\2\2\u00e3"+
		"\u00e7\7\27\2\2\u00e4\u00e5\f\21\2\2\u00e5\u00e7\7\63\2\2\u00e6\u00d4"+
		"\3\2\2\2\u00e6\u00d7\3\2\2\2\u00e6\u00da\3\2\2\2\u00e6\u00dd\3\2\2\2\u00e6"+
		"\u00e0\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00ea\3\2"+
		"\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\r\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00eb\u00ec\t\5\2\2\u00ec\u00ed\7Z\2\2\u00ed\u00ee\5\f\7\2\u00ee"+
		"\u00ef\7[\2\2\u00ef\u00f8\3\2\2\2\u00f0\u00f1\7\36\2\2\u00f1\u00f2\7Z"+
		"\2\2\u00f2\u00f3\5\f\7\2\u00f3\u00f4\7`\2\2\u00f4\u00f5\5\f\7\2\u00f5"+
		"\u00f6\7[\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00eb\3\2\2\2\u00f7\u00f0\3\2"+
		"\2\2\u00f8\17\3\2\2\2\u00f9\u00fa\t\6\2\2\u00fa\u00fb\7Z\2\2\u00fb\u00fc"+
		"\5\f\7\2\u00fc\u00fd\7`\2\2\u00fd\u00fe\5\f\7\2\u00fe\u00ff\7[\2\2\u00ff"+
		"\21\3\2\2\2\u0100\u0101\t\7\2\2\u0101\u0102\5\f\7\2\u0102\u0103\7`\2\2"+
		"\u0103\u0104\5\f\7\2\u0104\u0105\7]\2\2\u0105\u0106\7Z\2\2\u0106\u0107"+
		"\5\f\7\2\u0107\u0108\7[\2\2\u0108\23\3\2\2\2\u0109\u010a\7Z\2\2\u010a"+
		"\u010b\5\24\13\2\u010b\u010c\7[\2\2\u010c\u011a\3\2\2\2\u010d\u0117\5"+
		"*\26\2\u010e\u010f\7C\2\2\u010f\u0114\5\f\7\2\u0110\u0111\7C\2\2\u0111"+
		"\u0113\5\f\7\2\u0112\u0110\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0114\u0115\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0117"+
		"\u010e\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\3\2\2\2\u0119\u0109\3\2"+
		"\2\2\u0119\u010d\3\2\2\2\u011a\25\3\2\2\2\u011b\u011c\7Z\2\2\u011c\u011d"+
		"\5\26\f\2\u011d\u011e\7[\2\2\u011e\u012c\3\2\2\2\u011f\u0129\5,\27\2\u0120"+
		"\u0121\7D\2\2\u0121\u0126\5\f\7\2\u0122\u0123\7D\2\2\u0123\u0125\5\f\7"+
		"\2\u0124\u0122\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127"+
		"\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u0120\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u011b\3\2\2\2\u012b\u011f\3\2"+
		"\2\2\u012c\27\3\2\2\2\u012d\u012e\7Z\2\2\u012e\u012f\5\30\r\2\u012f\u0130"+
		"\7[\2\2\u0130\u013e\3\2\2\2\u0131\u013b\5.\30\2\u0132\u0133\t\b\2\2\u0133"+
		"\u0138\5\f\7\2\u0134\u0135\t\b\2\2\u0135\u0137\5\f\7\2\u0136\u0134\3\2"+
		"\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u0132\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u013e\3\2\2\2\u013d\u012d\3\2\2\2\u013d\u0131\3\2\2\2\u013e"+
		"\31\3\2\2\2\u013f\u0140\t\t\2\2\u0140\u0141\7g\2\2\u0141\u014c\7Z\2\2"+
		"\u0142\u0147\5\"\22\2\u0143\u0144\7`\2\2\u0144\u0146\5\"\22\2\u0145\u0143"+
		"\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u0142\3\2\2\2\u014b\u014e\3\2"+
		"\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e"+
		"\u014c\3\2\2\2\u014f\u0150\7[\2\2\u0150\33\3\2\2\2\u0151\u0152\5\62\32"+
		"\2\u0152\u0153\7c\2\2\u0153\u0154\5\"\22\2\u0154\35\3\2\2\2\u0155\u0156"+
		"\t\n\2\2\u0156\37\3\2\2\2\u0157\u015c\7\b\2\2\u0158\u015c\7\t\2\2\u0159"+
		"\u015c\t\13\2\2\u015a\u015c\t\f\2\2\u015b\u0157\3\2\2\2\u015b\u0158\3"+
		"\2\2\2\u015b\u0159\3\2\2\2\u015b\u015a\3\2\2\2\u015c!\3\2\2\2\u015d\u0166"+
		"\5(\25\2\u015e\u0166\5\24\13\2\u015f\u0166\5\26\f\2\u0160\u0166\5\30\r"+
		"\2\u0161\u0166\5\n\6\2\u0162\u0166\5\f\7\2\u0163\u0166\5\62\32\2\u0164"+
		"\u0166\5\60\31\2\u0165\u015d\3\2\2\2\u0165\u015e\3\2\2\2\u0165\u015f\3"+
		"\2\2\2\u0165\u0160\3\2\2\2\u0165\u0161\3\2\2\2\u0165\u0162\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0165\u0164\3\2\2\2\u0166#\3\2\2\2\u0167\u0184\t\r\2\2"+
		"\u0168\u0169\7\3\2\2\u0169\u016a\5\n\6\2\u016a\u016b\7\4\2\2\u016b\u0171"+
		"\5\n\6\2\u016c\u016d\7\6\2\2\u016d\u016e\5\n\6\2\u016e\u016f\7\4\2\2\u016f"+
		"\u0170\5\n\6\2\u0170\u0172\3\2\2\2\u0171\u016c\3\2\2\2\u0171\u0172\3\2"+
		"\2\2\u0172\u0173\3\2\2\2\u0173\u0174\7\5\2\2\u0174\u0175\5\n\6\2\u0175"+
		"\u0176\7\7\2\2\u0176\u0184\3\2\2\2\u0177\u0179\7o\2\2\u0178\u0177\3\2"+
		"\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u0184\5\60\31\2\u017b"+
		"\u017d\7o\2\2\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2"+
		"\2\2\u017e\u0184\5\32\16\2\u017f\u0181\7o\2\2\u0180\u017f\3\2\2\2\u0180"+
		"\u0181\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0184\7g\2\2\u0183\u0167\3\2"+
		"\2\2\u0183\u0168\3\2\2\2\u0183\u0178\3\2\2\2\u0183\u017c\3\2\2\2\u0183"+
		"\u0180\3\2\2\2\u0184%\3\2\2\2\u0185\u0186\7\3\2\2\u0186\u0187\5\n\6\2"+
		"\u0187\u0188\7\4\2\2\u0188\u018e\5\f\7\2\u0189\u018a\7\6\2\2\u018a\u018b"+
		"\5\n\6\2\u018b\u018c\7\4\2\2\u018c\u018d\5\f\7\2\u018d\u018f\3\2\2\2\u018e"+
		"\u0189\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\7\5"+
		"\2\2\u0191\u0192\5\f\7\2\u0192\u0193\7\7\2\2\u0193\u01a9\3\2\2\2\u0194"+
		"\u01a9\7\62\2\2\u0195\u01a9\7\61\2\2\u0196\u01a9\7!\2\2\u0197\u01a9\7"+
		"\"\2\2\u0198\u01a9\7j\2\2\u0199\u019b\7p\2\2\u019a\u0199\3\2\2\2\u019a"+
		"\u019b\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u01a9\5\60\31\2\u019d\u019f\7"+
		"p\2\2\u019e\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a9\5\32\16\2\u01a1\u01a3\7p\2\2\u01a2\u01a1\3\2\2\2\u01a2\u01a3\3"+
		"\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a7\7g\2\2\u01a5\u01a7\7h\2\2\u01a6"+
		"\u01a2\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7\u01a9\3\2\2\2\u01a8\u0185\3\2"+
		"\2\2\u01a8\u0194\3\2\2\2\u01a8\u0195\3\2\2\2\u01a8\u0196\3\2\2\2\u01a8"+
		"\u0197\3\2\2\2\u01a8\u0198\3\2\2\2\u01a8\u019a\3\2\2\2\u01a8\u019e\3\2"+
		"\2\2\u01a8\u01a6\3\2\2\2\u01a9\'\3\2\2\2\u01aa\u01ab\7\3\2\2\u01ab\u01ac"+
		"\5\n\6\2\u01ac\u01ad\7\4\2\2\u01ad\u01b3\5(\25\2\u01ae\u01af\7\6\2\2\u01af"+
		"\u01b0\5\n\6\2\u01b0\u01b1\7\4\2\2\u01b1\u01b2\5(\25\2\u01b2\u01b4\3\2"+
		"\2\2\u01b3\u01ae\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5"+
		"\u01b6\7\5\2\2\u01b6\u01b7\5(\25\2\u01b7\u01b8\7\7\2\2\u01b8\u01c7\3\2"+
		"\2\2\u01b9\u01c7\7i\2\2\u01ba\u01bc\7q\2\2\u01bb\u01ba\3\2\2\2\u01bb\u01bc"+
		"\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01c7\5\60\31\2\u01be\u01c0\7q\2\2"+
		"\u01bf\u01be\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c7"+
		"\5\32\16\2\u01c2\u01c4\7q\2\2\u01c3\u01c2\3\2\2\2\u01c3\u01c4\3\2\2\2"+
		"\u01c4\u01c5\3\2\2\2\u01c5\u01c7\7g\2\2\u01c6\u01aa\3\2\2\2\u01c6\u01b9"+
		"\3\2\2\2\u01c6\u01bb\3\2\2\2\u01c6\u01bf\3\2\2\2\u01c6\u01c3\3\2\2\2\u01c7"+
		")\3\2\2\2\u01c8\u01c9\7\3\2\2\u01c9\u01ca\5\n\6\2\u01ca\u01cb\7\4\2\2"+
		"\u01cb\u01d1\5\24\13\2\u01cc\u01cd\7\6\2\2\u01cd\u01ce\5\n\6\2\u01ce\u01cf"+
		"\7\4\2\2\u01cf\u01d0\5\24\13\2\u01d0\u01d2\3\2\2\2\u01d1\u01cc\3\2\2\2"+
		"\u01d1\u01d2\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d4\7\5\2\2\u01d4\u01d5"+
		"\5\24\13\2\u01d5\u01d6\7\7\2\2\u01d6\u01e6\3\2\2\2\u01d7\u01e6\7l\2\2"+
		"\u01d8\u01e6\7E\2\2\u01d9\u01db\7r\2\2\u01da\u01d9\3\2\2\2\u01da\u01db"+
		"\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01e6\7g\2\2\u01dd\u01df\7r\2\2\u01de"+
		"\u01dd\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e6\5\32"+
		"\16\2\u01e1\u01e3\7r\2\2\u01e2\u01e1\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3"+
		"\u01e4\3\2\2\2\u01e4\u01e6\5\60\31\2\u01e5\u01c8\3\2\2\2\u01e5\u01d7\3"+
		"\2\2\2\u01e5\u01d8\3\2\2\2\u01e5\u01da\3\2\2\2\u01e5\u01de\3\2\2\2\u01e5"+
		"\u01e2\3\2\2\2\u01e6+\3\2\2\2\u01e7\u01e8\7\3\2\2\u01e8\u01e9\5\n\6\2"+
		"\u01e9\u01ea\7\4\2\2\u01ea\u01f0\5\26\f\2\u01eb\u01ec\7\6\2\2\u01ec\u01ed"+
		"\5\n\6\2\u01ed\u01ee\7\4\2\2\u01ee\u01ef\5\26\f\2\u01ef\u01f1\3\2\2\2"+
		"\u01f0\u01eb\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f3"+
		"\7\5\2\2\u01f3\u01f4\5\26\f\2\u01f4\u01f5\7\7\2\2\u01f5\u0205\3\2\2\2"+
		"\u01f6\u0205\7m\2\2\u01f7\u0205\7F\2\2\u01f8\u01fa\7s\2\2\u01f9\u01f8"+
		"\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u0205\7g\2\2\u01fc"+
		"\u01fe\7s\2\2\u01fd\u01fc\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\3\2"+
		"\2\2\u01ff\u0205\5\32\16\2\u0200\u0202\7s\2\2\u0201\u0200\3\2\2\2\u0201"+
		"\u0202\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0205\5\60\31\2\u0204\u01e7\3"+
		"\2\2\2\u0204\u01f6\3\2\2\2\u0204\u01f7\3\2\2\2\u0204\u01f9\3\2\2\2\u0204"+
		"\u01fd\3\2\2\2\u0204\u0201\3\2\2\2\u0205-\3\2\2\2\u0206\u0207\7\3\2\2"+
		"\u0207\u0208\5\n\6\2\u0208\u0209\7\4\2\2\u0209\u020f\5\30\r\2\u020a\u020b"+
		"\7\6\2\2\u020b\u020c\5\n\6\2\u020c\u020d\7\4\2\2\u020d\u020e\5\30\r\2"+
		"\u020e\u0210\3\2\2\2\u020f\u020a\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211"+
		"\3\2\2\2\u0211\u0212\7\5\2\2\u0212\u0213\5\30\r\2\u0213\u0214\7\7\2\2"+
		"\u0214\u0224\3\2\2\2\u0215\u0224\7n\2\2\u0216\u0224\7G\2\2\u0217\u0219"+
		"\7t\2\2\u0218\u0217\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021a\3\2\2\2\u021a"+
		"\u0224\7g\2\2\u021b\u021d\7t\2\2\u021c\u021b\3\2\2\2\u021c\u021d\3\2\2"+
		"\2\u021d\u021e\3\2\2\2\u021e\u0224\5\32\16\2\u021f\u0221\7t\2\2\u0220"+
		"\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0224\5\60"+
		"\31\2\u0223\u0206\3\2\2\2\u0223\u0215\3\2\2\2\u0223\u0216\3\2\2\2\u0223"+
		"\u0218\3\2\2\2\u0223\u021c\3\2\2\2\u0223\u0220\3\2\2\2\u0224/\3\2\2\2"+
		"\u0225\u0226\7\3\2\2\u0226\u0227\5\n\6\2\u0227\u0228\7\4\2\2\u0228\u022e"+
		"\5\60\31\2\u0229\u022a\7\6\2\2\u022a\u022b\5\n\6\2\u022b\u022c\7\4\2\2"+
		"\u022c\u022d\5\60\31\2\u022d\u022f\3\2\2\2\u022e\u0229\3\2\2\2\u022e\u022f"+
		"\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0231\7\5\2\2\u0231\u0232\5\60\31\2"+
		"\u0232\u0233\7\7\2\2\u0233\u0237\3\2\2\2\u0234\u0235\7g\2\2\u0235\u0237"+
		"\7d\2\2\u0236\u0225\3\2\2\2\u0236\u0234\3\2\2\2\u0237\61\3\2\2\2\u0238"+
		"\u0239\7\3\2\2\u0239\u023a\5\n\6\2\u023a\u023b\7\4\2\2\u023b\u0241\5\34"+
		"\17\2\u023c\u023d\7\6\2\2\u023d\u023e\5\n\6\2\u023e\u023f\7\4\2\2\u023f"+
		"\u0240\5\34\17\2\u0240\u0242\3\2\2\2\u0241\u023c\3\2\2\2\u0241\u0242\3"+
		"\2\2\2\u0242\u0243\3\2\2\2\u0243\u0244\7\5\2\2\u0244\u0245\5\34\17\2\u0245"+
		"\u0246\7\7\2\2\u0246\u02a3\3\2\2\2\u0247\u0248\7\\\2\2\u0248\u024d\7j"+
		"\2\2\u0249\u024a\7`\2\2\u024a\u024c\7j\2\2\u024b\u0249\3\2\2\2\u024c\u024f"+
		"\3\2\2\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u0250\3\2\2\2\u024f"+
		"\u024d\3\2\2\2\u0250\u02a3\7]\2\2\u0251\u0252\7\\\2\2\u0252\u0257\t\r"+
		"\2\2\u0253\u0254\7`\2\2\u0254\u0256\t\r\2\2\u0255\u0253\3\2\2\2\u0256"+
		"\u0259\3\2\2\2\u0257\u0255\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u025a\3\2"+
		"\2\2\u0259\u0257\3\2\2\2\u025a\u02a3\7]\2\2\u025b\u025c\7\\\2\2\u025c"+
		"\u0261\7i\2\2\u025d\u025e\7`\2\2\u025e\u0260\7i\2\2\u025f\u025d\3\2\2"+
		"\2\u0260\u0263\3\2\2\2\u0261\u025f\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0264"+
		"\3\2\2\2\u0263\u0261\3\2\2\2\u0264\u02a3\7]\2\2\u0265\u0266\7\\\2\2\u0266"+
		"\u026b\7l\2\2\u0267\u0268\7`\2\2\u0268\u026a\7l\2\2\u0269\u0267\3\2\2"+
		"\2\u026a\u026d\3\2\2\2\u026b\u0269\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026e"+
		"\3\2\2\2\u026d\u026b\3\2\2\2\u026e\u02a3\7]\2\2\u026f\u0270\7\\\2\2\u0270"+
		"\u0275\7m\2\2\u0271\u0272\7`\2\2\u0272\u0274\7m\2\2\u0273\u0271\3\2\2"+
		"\2\u0274\u0277\3\2\2\2\u0275\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0278"+
		"\3\2\2\2\u0277\u0275\3\2\2\2\u0278\u02a3\7]\2\2\u0279\u027a\7\\\2\2\u027a"+
		"\u027f\7n\2\2\u027b\u027c\7`\2\2\u027c\u027e\7n\2\2\u027d\u027b\3\2\2"+
		"\2\u027e\u0281\3\2\2\2\u027f\u027d\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0282"+
		"\3\2\2\2\u0281\u027f\3\2\2\2\u0282\u02a3\7]\2\2\u0283\u0284\7\\\2\2\u0284"+
		"\u0289\7g\2\2\u0285\u0286\7`\2\2\u0286\u0288\7g\2\2\u0287\u0285\3\2\2"+
		"\2\u0288\u028b\3\2\2\2\u0289\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028c"+
		"\3\2\2\2\u028b\u0289\3\2\2\2\u028c\u02a3\7]\2\2\u028d\u028e\7\\\2\2\u028e"+
		"\u0293\5\60\31\2\u028f\u0290\7`\2\2\u0290\u0292\5\60\31\2\u0291\u028f"+
		"\3\2\2\2\u0292\u0295\3\2\2\2\u0293\u0291\3\2\2\2\u0293\u0294\3\2\2\2\u0294"+
		"\u0296\3\2\2\2\u0295\u0293\3\2\2\2\u0296\u0297\7]\2\2\u0297\u02a3\3\2"+
		"\2\2\u0298\u0299\7\\\2\2\u0299\u029a\5\32\16\2\u029a\u029b\7]\2\2\u029b"+
		"\u02a3\3\2\2\2\u029c\u029d\7u\2\2\u029d\u02a3\5\32\16\2\u029e\u029f\7"+
		"u\2\2\u029f\u02a3\5\60\31\2\u02a0\u02a1\7u\2\2\u02a1\u02a3\7g\2\2\u02a2"+
		"\u0238\3\2\2\2\u02a2\u0247\3\2\2\2\u02a2\u0251\3\2\2\2\u02a2\u025b\3\2"+
		"\2\2\u02a2\u0265\3\2\2\2\u02a2\u026f\3\2\2\2\u02a2\u0279\3\2\2\2\u02a2"+
		"\u0283\3\2\2\2\u02a2\u028d\3\2\2\2\u02a2\u0298\3\2\2\2\u02a2\u029c\3\2"+
		"\2\2\u02a2\u029e\3\2\2\2\u02a2\u02a0\3\2\2\2\u02a3\63\3\2\2\2D\66;DHn"+
		"v\u00d2\u00e6\u00e8\u00f7\u0114\u0117\u0119\u0126\u0129\u012b\u0138\u013b"+
		"\u013d\u0147\u014c\u015b\u0165\u0171\u0178\u017c\u0180\u0183\u018e\u019a"+
		"\u019e\u01a2\u01a6\u01a8\u01b3\u01bb\u01bf\u01c3\u01c6\u01d1\u01da\u01de"+
		"\u01e2\u01e5\u01f0\u01f9\u01fd\u0201\u0204\u020f\u0218\u021c\u0220\u0223"+
		"\u022e\u0236\u0241\u024d\u0257\u0261\u026b\u0275\u027f\u0289\u0293\u02a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}