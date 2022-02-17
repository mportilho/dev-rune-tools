// Generated from D:/dev/git/dev-rune-tools/mathlogical-sentence-compiler/src/main/resources\MathematicalSentenceParserGrammar.g4 by ANTLR 4.9.2

    package io.github.mportilho.sentencecompiler.grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MathematicalSentenceParserGrammarLexer extends Lexer {
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
		MINUS_PARENTHESIS=33, PI=34, EULER=35, DEGREE=36, GT=37, GE=38, LT=39, 
		LE=40, EQ=41, NEQ=42, NOT=43, R_UP=44, R_DOWN=45, R_CEILING=46, R_FLOOR=47, 
		R_HALF_UP=48, R_HALF_DOWN=49, R_HALF_EVEN=50, R_UNNECESSARY=51, DATE_OPERATIONS=52, 
		TIME_OPERATIONS=53, NOW_DATE=54, NOW_TIME=55, NOW_DATETIME=56, PLUS_DAYS=57, 
		PLUS_MONTHS=58, PLUS_YEARS=59, PLUS_HOURS=60, PLUS_MINUTES=61, PLUS_SECONDS=62, 
		MINUS_DAYS=63, MINUS_MONTHS=64, MINUS_YEARS=65, MINUS_HOURS=66, MINUS_MINUTES=67, 
		MINUS_SECONDS=68, SET_DAYS=69, SET_MONTHS=70, SET_YEARS=71, SET_HOURS=72, 
		SET_MINUTES=73, SET_SECONDS=74, LPAREN=75, RPAREN=76, LBLACKET=77, RBLACKET=78, 
		QUOTES=79, ASSIGNMENT=80, COMMA=81, SEMI=82, PERIOD=83, CONTAINS=84, JSON_PATH=85, 
		CACHE_FUNCTION_PREFIX=86, IDENTIFIER=87, NEGATIVE_IDENTIFIER=88, STRING=89, 
		NUMBER=90, POSITIVE=91, DATE=92, TIME=93, DATETIME=94, BOOLEAN_TYPE=95, 
		NUMBER_TYPE=96, STRING_TYPE=97, DATE_TYPE=98, TIME_TYPE=99, DATETIME_TYPE=100, 
		LIST_TYPE=101, DAY_PART=102, MONTH_PART=103, HOUR_PART=104, MINUTE_SECOND_PART=105, 
		TIME_OFFSET=106, COMMENT=107, WS=108;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IF", "THEN", "ELSE", "ELSEIF", "ENDIF", "AND", "OR", "XOR", "XNOR", 
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
			"SEMI", "PERIOD", "CONTAINS", "JSON_PATH", "CACHE_FUNCTION_PREFIX", "IDENTIFIER", 
			"NEGATIVE_IDENTIFIER", "STRING", "NUMBER", "POSITIVE", "DATE", "TIME", 
			"DATETIME", "BOOLEAN_TYPE", "NUMBER_TYPE", "STRING_TYPE", "DATE_TYPE", 
			"TIME_TYPE", "DATETIME_TYPE", "LIST_TYPE", "DAY_PART", "MONTH_PART", 
			"HOUR_PART", "MINUTE_SECOND_PART", "TIME_OFFSET", "IdentifierText", "NegativeSymbol", 
			"Decimal", "PositiveNumber", "OctalDigits", "HexDigits", "IdentifierStart", 
			"IdentifierPart", "NumberPart", "Colon", "Slash", "JsonPathSeparator", 
			"RawTextNoWhiteSpace", "RawAlphabeticNoWhiteSpace", "MinusParenthesisOperator", 
			"COMMENT", "WS"
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
			"'''", "':='", "','", "';'", "'.'", "'contains'", null, "'$.'", null, 
			null, null, null, null, null, null, null, "'<bool>'", "'<number>'", "'<text>'", 
			"'<date>'", "'<time>'", "'<datetime>'", "'<list>'"
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
			"SEMI", "PERIOD", "CONTAINS", "JSON_PATH", "CACHE_FUNCTION_PREFIX", "IDENTIFIER", 
			"NEGATIVE_IDENTIFIER", "STRING", "NUMBER", "POSITIVE", "DATE", "TIME", 
			"DATETIME", "BOOLEAN_TYPE", "NUMBER_TYPE", "STRING_TYPE", "DATE_TYPE", 
			"TIME_TYPE", "DATETIME_TYPE", "LIST_TYPE", "DAY_PART", "MONTH_PART", 
			"HOUR_PART", "MINUTE_SECOND_PART", "TIME_OFFSET", "COMMENT", "WS"
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


	public MathematicalSentenceParserGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MathematicalSentenceParserGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2n\u03ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0150\n\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\5#\u0174\n#\3#\3#\3#\3#\5#\u017a\n#\3$\5"+
		"$\u017d\n$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u018f\n"+
		"%\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\3+\5+\u01a1\n+\3,\3"+
		",\3,\5,\u01a6\n,\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u01ec\n\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u01f7\n\66\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38\38\38\39\39\39\39\39\3"+
		"9\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3"+
		";\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3"+
		"=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3"+
		"?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3"+
		"A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3"+
		"C\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3E\3"+
		"E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3H\3"+
		"H\3H\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J\3"+
		"J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3L\3L\3M\3M\3N\3N\3O\3"+
		"O\3P\3P\3Q\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3U\3U\3U\3U\3U\3U\3U\3V\3V\3"+
		"V\3V\3V\3V\3W\3W\3W\3X\3X\3Y\3Y\3Y\3Z\3Z\7Z\u0304\nZ\fZ\16Z\u0307\13Z"+
		"\3Z\3Z\3[\3[\3[\5[\u030e\n[\3\\\3\\\3]\3]\3]\3]\3]\3]\3]\3]\3]\3^\3^\3"+
		"^\3^\3^\3^\5^\u0321\n^\3_\3_\3_\3_\5_\u0327\n_\3`\3`\3`\3`\3`\3`\3`\3"+
		"a\3a\3a\3a\3a\3a\3a\3a\3a\3b\3b\3b\3b\3b\3b\3b\3c\3c\3c\3c\3c\3c\3c\3"+
		"d\3d\3d\3d\3d\3d\3d\3e\3e\3e\3e\3e\3e\3e\3e\3e\3e\3e\3f\3f\3f\3f\3f\3"+
		"f\3f\3g\3g\3g\3g\3g\3g\5g\u0366\ng\3h\3h\3h\3h\5h\u036c\nh\3i\3i\3i\3"+
		"i\5i\u0372\ni\3j\3j\3j\3k\3k\3k\3k\3k\3k\3k\3l\3l\7l\u0380\nl\fl\16l\u0383"+
		"\13l\3m\3m\3n\5n\u0388\nn\3n\6n\u038b\nn\rn\16n\u038c\3n\3n\6n\u0391\n"+
		"n\rn\16n\u0392\5n\u0395\nn\3o\6o\u0398\no\ro\16o\u0399\3p\3p\6p\u039e"+
		"\np\rp\16p\u039f\3q\3q\3q\3q\6q\u03a6\nq\rq\16q\u03a7\3r\3r\3s\3s\3s\5"+
		"s\u03af\ns\3t\3t\3u\3u\3v\3v\3w\3w\3w\3x\3x\3x\6x\u03bd\nx\rx\16x\u03be"+
		"\3y\3y\3y\6y\u03c4\ny\ry\16y\u03c5\3z\3z\3z\3{\3{\3{\3{\7{\u03cf\n{\f"+
		"{\16{\u03d2\13{\3{\5{\u03d5\n{\3{\3{\3{\3{\3{\7{\u03dc\n{\f{\16{\u03df"+
		"\13{\3{\3{\3{\5{\u03e4\n{\3{\3{\3|\6|\u03e9\n|\r|\16|\u03ea\3|\3|\3\u03dd"+
		"\2}\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008d"+
		"H\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1"+
		"R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00adX\u00afY\u00b1Z\u00b3[\u00b5"+
		"\\\u00b7]\u00b9^\u00bb_\u00bd`\u00bfa\u00c1b\u00c3c\u00c5d\u00c7e\u00c9"+
		"f\u00cbg\u00cdh\u00cfi\u00d1j\u00d3k\u00d5l\u00d7\2\u00d9\2\u00db\2\u00dd"+
		"\2\u00df\2\u00e1\2\u00e3\2\u00e5\2\u00e7\2\u00e9\2\u00eb\2\u00ed\2\u00ef"+
		"\2\u00f1\2\u00f3\2\u00f5m\u00f7n\3\2\16\3\2))\4\2--//\5\2C\\aac|\6\2\62"+
		";C\\aac|\3\2\62;\5\2\62;CHch\4\2C\\c|\4\2$$^^\7\2\13\f\16\17\"\"$$^^\b"+
		"\2\13\f\16\17\"\"$$\62;^^\4\2\f\f\17\17\5\2\13\f\16\17\"\"\2\u0413\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3"+
		"\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2"+
		"\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb"+
		"\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2"+
		"\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd"+
		"\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2"+
		"\2\2\u00f5\3\2\2\2\2\u00f7\3\2\2\2\3\u00f9\3\2\2\2\5\u00fc\3\2\2\2\7\u0101"+
		"\3\2\2\2\t\u0106\3\2\2\2\13\u010c\3\2\2\2\r\u0112\3\2\2\2\17\u0116\3\2"+
		"\2\2\21\u0119\3\2\2\2\23\u011d\3\2\2\2\25\u0122\3\2\2\2\27\u0127\3\2\2"+
		"\2\31\u012b\3\2\2\2\33\u0130\3\2\2\2\35\u0136\3\2\2\2\37\u0138\3\2\2\2"+
		"!\u013a\3\2\2\2#\u013c\3\2\2\2%\u013e\3\2\2\2\'\u0140\3\2\2\2)\u0144\3"+
		"\2\2\2+\u0146\3\2\2\2-\u0148\3\2\2\2/\u014f\3\2\2\2\61\u0151\3\2\2\2\63"+
		"\u0156\3\2\2\2\65\u0159\3\2\2\2\67\u015c\3\2\2\29\u0162\3\2\2\2;\u0166"+
		"\3\2\2\2=\u0169\3\2\2\2?\u016c\3\2\2\2A\u016e\3\2\2\2C\u0170\3\2\2\2E"+
		"\u0173\3\2\2\2G\u017c\3\2\2\2I\u018e\3\2\2\2K\u0190\3\2\2\2M\u0192\3\2"+
		"\2\2O\u0195\3\2\2\2Q\u0197\3\2\2\2S\u019a\3\2\2\2U\u01a0\3\2\2\2W\u01a5"+
		"\3\2\2\2Y\u01a7\3\2\2\2[\u01aa\3\2\2\2]\u01af\3\2\2\2_\u01b7\3\2\2\2a"+
		"\u01bd\3\2\2\2c\u01c4\3\2\2\2e\u01cd\3\2\2\2g\u01d6\3\2\2\2i\u01eb\3\2"+
		"\2\2k\u01f6\3\2\2\2m\u01f8\3\2\2\2o\u0201\3\2\2\2q\u020a\3\2\2\2s\u0217"+
		"\3\2\2\2u\u0220\3\2\2\2w\u022b\3\2\2\2y\u0235\3\2\2\2{\u023f\3\2\2\2}"+
		"\u024b\3\2\2\2\177\u0257\3\2\2\2\u0081\u0261\3\2\2\2\u0083\u026d\3\2\2"+
		"\2\u0085\u0278\3\2\2\2\u0087\u0283\3\2\2\2\u0089\u0290\3\2\2\2\u008b\u029d"+
		"\3\2\2\2\u008d\u02a5\3\2\2\2\u008f\u02af\3\2\2\2\u0091\u02b8\3\2\2\2\u0093"+
		"\u02c1\3\2\2\2\u0095\u02cc\3\2\2\2\u0097\u02d7\3\2\2\2\u0099\u02d9\3\2"+
		"\2\2\u009b\u02db\3\2\2\2\u009d\u02dd\3\2\2\2\u009f\u02df\3\2\2\2\u00a1"+
		"\u02e1\3\2\2\2\u00a3\u02e4\3\2\2\2\u00a5\u02e6\3\2\2\2\u00a7\u02e8\3\2"+
		"\2\2\u00a9\u02ea\3\2\2\2\u00ab\u02f3\3\2\2\2\u00ad\u02f9\3\2\2\2\u00af"+
		"\u02fc\3\2\2\2\u00b1\u02fe\3\2\2\2\u00b3\u0301\3\2\2\2\u00b5\u030d\3\2"+
		"\2\2\u00b7\u030f\3\2\2\2\u00b9\u0311\3\2\2\2\u00bb\u031a\3\2\2\2\u00bd"+
		"\u0322\3\2\2\2\u00bf\u0328\3\2\2\2\u00c1\u032f\3\2\2\2\u00c3\u0338\3\2"+
		"\2\2\u00c5\u033f\3\2\2\2\u00c7\u0346\3\2\2\2\u00c9\u034d\3\2\2\2\u00cb"+
		"\u0358\3\2\2\2\u00cd\u0365\3\2\2\2\u00cf\u036b\3\2\2\2\u00d1\u0371\3\2"+
		"\2\2\u00d3\u0373\3\2\2\2\u00d5\u0376\3\2\2\2\u00d7\u037d\3\2\2\2\u00d9"+
		"\u0384\3\2\2\2\u00db\u0387\3\2\2\2\u00dd\u0397\3\2\2\2\u00df\u039b\3\2"+
		"\2\2\u00e1\u03a1\3\2\2\2\u00e3\u03a9\3\2\2\2\u00e5\u03ae\3\2\2\2\u00e7"+
		"\u03b0\3\2\2\2\u00e9\u03b2\3\2\2\2\u00eb\u03b4\3\2\2\2\u00ed\u03b6\3\2"+
		"\2\2\u00ef\u03bc\3\2\2\2\u00f1\u03c3\3\2\2\2\u00f3\u03c7\3\2\2\2\u00f5"+
		"\u03e3\3\2\2\2\u00f7\u03e8\3\2\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7h\2"+
		"\2\u00fb\4\3\2\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7j\2\2\u00fe\u00ff\7"+
		"g\2\2\u00ff\u0100\7p\2\2\u0100\6\3\2\2\2\u0101\u0102\7g\2\2\u0102\u0103"+
		"\7n\2\2\u0103\u0104\7u\2\2\u0104\u0105\7g\2\2\u0105\b\3\2\2\2\u0106\u0107"+
		"\7g\2\2\u0107\u0108\7n\2\2\u0108\u0109\7u\2\2\u0109\u010a\7k\2\2\u010a"+
		"\u010b\7h\2\2\u010b\n\3\2\2\2\u010c\u010d\7g\2\2\u010d\u010e\7p\2\2\u010e"+
		"\u010f\7f\2\2\u010f\u0110\7k\2\2\u0110\u0111\7h\2\2\u0111\f\3\2\2\2\u0112"+
		"\u0113\7c\2\2\u0113\u0114\7p\2\2\u0114\u0115\7f\2\2\u0115\16\3\2\2\2\u0116"+
		"\u0117\7q\2\2\u0117\u0118\7t\2\2\u0118\20\3\2\2\2\u0119\u011a\7z\2\2\u011a"+
		"\u011b\7q\2\2\u011b\u011c\7t\2\2\u011c\22\3\2\2\2\u011d\u011e\7z\2\2\u011e"+
		"\u011f\7p\2\2\u011f\u0120\7q\2\2\u0120\u0121\7t\2\2\u0121\24\3\2\2\2\u0122"+
		"\u0123\7p\2\2\u0123\u0124\7c\2\2\u0124\u0125\7p\2\2\u0125\u0126\7f\2\2"+
		"\u0126\26\3\2\2\2\u0127\u0128\7p\2\2\u0128\u0129\7q\2\2\u0129\u012a\7"+
		"t\2\2\u012a\30\3\2\2\2\u012b\u012c\7v\2\2\u012c\u012d\7t\2\2\u012d\u012e"+
		"\7w\2\2\u012e\u012f\7g\2\2\u012f\32\3\2\2\2\u0130\u0131\7h\2\2\u0131\u0132"+
		"\7c\2\2\u0132\u0133\7n\2\2\u0133\u0134\7u\2\2\u0134\u0135\7g\2\2\u0135"+
		"\34\3\2\2\2\u0136\u0137\7,\2\2\u0137\36\3\2\2\2\u0138\u0139\7\61\2\2\u0139"+
		" \3\2\2\2\u013a\u013b\7-\2\2\u013b\"\3\2\2\2\u013c\u013d\7/\2\2\u013d"+
		"$\3\2\2\2\u013e\u013f\7\'\2\2\u013f&\3\2\2\2\u0140\u0141\7o\2\2\u0141"+
		"\u0142\7q\2\2\u0142\u0143\7f\2\2\u0143(\3\2\2\2\u0144\u0145\7~\2\2\u0145"+
		"*\3\2\2\2\u0146\u0147\7#\2\2\u0147,\3\2\2\2\u0148\u0149\7`\2\2\u0149."+
		"\3\2\2\2\u014a\u014b\7t\2\2\u014b\u014c\7q\2\2\u014c\u014d\7q\2\2\u014d"+
		"\u0150\7v\2\2\u014e\u0150\7\u221c\2\2\u014f\u014a\3\2\2\2\u014f\u014e"+
		"\3\2\2\2\u0150\60\3\2\2\2\u0151\u0152\7u\2\2\u0152\u0153\7s\2\2\u0153"+
		"\u0154\7t\2\2\u0154\u0155\7v\2\2\u0155\62\3\2\2\2\u0156\u0157\7n\2\2\u0157"+
		"\u0158\7d\2\2\u0158\64\3\2\2\2\u0159\u015a\7n\2\2\u015a\u015b\7p\2\2\u015b"+
		"\66\3\2\2\2\u015c\u015d\7n\2\2\u015d\u015e\7q\2\2\u015e\u015f\7i\2\2\u015f"+
		"\u0160\7\63\2\2\u0160\u0161\7\62\2\2\u01618\3\2\2\2\u0162\u0163\7n\2\2"+
		"\u0163\u0164\7q\2\2\u0164\u0165\7i\2\2\u0165:\3\2\2\2\u0166\u0167\7U\2"+
		"\2\u0167\u0168\7]\2\2\u0168<\3\2\2\2\u0169\u016a\7R\2\2\u016a\u016b\7"+
		"]\2\2\u016b>\3\2\2\2\u016c\u016d\7U\2\2\u016d@\3\2\2\2\u016e\u016f\7R"+
		"\2\2\u016fB\3\2\2\2\u0170\u0171\5\u00f3z\2\u0171D\3\2\2\2\u0172\u0174"+
		"\5#\22\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0179\3\2\2\2\u0175"+
		"\u0176\7r\2\2\u0176\u017a\7k\2\2\u0177\u0178\7R\2\2\u0178\u017a\7K\2\2"+
		"\u0179\u0175\3\2\2\2\u0179\u0177\3\2\2\2\u017aF\3\2\2\2\u017b\u017d\5"+
		"#\22\2\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u017f\7G\2\2\u017fH\3\2\2\2\u0180\u018f\7\u00b2\2\2\u0181\u0182\7f\2"+
		"\2\u0182\u0183\7g\2\2\u0183\u0184\7i\2\2\u0184\u0185\7i\2\2\u0185\u0186"+
		"\7t\2\2\u0186\u018f\7g\2\2\u0187\u0188\7f\2\2\u0188\u0189\7g\2\2\u0189"+
		"\u018a\7i\2\2\u018a\u018b\7i\2\2\u018b\u018c\7t\2\2\u018c\u018d\7g\2\2"+
		"\u018d\u018f\7u\2\2\u018e\u0180\3\2\2\2\u018e\u0181\3\2\2\2\u018e\u0187"+
		"\3\2\2\2\u018fJ\3\2\2\2\u0190\u0191\7@\2\2\u0191L\3\2\2\2\u0192\u0193"+
		"\7@\2\2\u0193\u0194\7?\2\2\u0194N\3\2\2\2\u0195\u0196\7>\2\2\u0196P\3"+
		"\2\2\2\u0197\u0198\7>\2\2\u0198\u0199\7?\2\2\u0199R\3\2\2\2\u019a\u019b"+
		"\7?\2\2\u019bT\3\2\2\2\u019c\u019d\7#\2\2\u019d\u01a1\7?\2\2\u019e\u019f"+
		"\7>\2\2\u019f\u01a1\7@\2\2\u01a0\u019c\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1"+
		"V\3\2\2\2\u01a2\u01a6\7\u0080\2\2\u01a3\u01a4\7\u00c4\2\2\u01a4\u01a6"+
		"\7\u00ae\2\2\u01a5\u01a2\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6X\3\2\2\2\u01a7"+
		"\u01a8\7w\2\2\u01a8\u01a9\7r\2\2\u01a9Z\3\2\2\2\u01aa\u01ab\7f\2\2\u01ab"+
		"\u01ac\7q\2\2\u01ac\u01ad\7y\2\2\u01ad\u01ae\7p\2\2\u01ae\\\3\2\2\2\u01af"+
		"\u01b0\7e\2\2\u01b0\u01b1\7g\2\2\u01b1\u01b2\7k\2\2\u01b2\u01b3\7n\2\2"+
		"\u01b3\u01b4\7k\2\2\u01b4\u01b5\7p\2\2\u01b5\u01b6\7i\2\2\u01b6^\3\2\2"+
		"\2\u01b7\u01b8\7h\2\2\u01b8\u01b9\7n\2\2\u01b9\u01ba\7q\2\2\u01ba\u01bb"+
		"\7q\2\2\u01bb\u01bc\7t\2\2\u01bc`\3\2\2\2\u01bd\u01be\7j\2\2\u01be\u01bf"+
		"\7c\2\2\u01bf\u01c0\7n\2\2\u01c0\u01c1\7h\2\2\u01c1\u01c2\7W\2\2\u01c2"+
		"\u01c3\7r\2\2\u01c3b\3\2\2\2\u01c4\u01c5\7j\2\2\u01c5\u01c6\7c\2\2\u01c6"+
		"\u01c7\7n\2\2\u01c7\u01c8\7h\2\2\u01c8\u01c9\7F\2\2\u01c9\u01ca\7q\2\2"+
		"\u01ca\u01cb\7y\2\2\u01cb\u01cc\7p\2\2\u01ccd\3\2\2\2\u01cd\u01ce\7j\2"+
		"\2\u01ce\u01cf\7c\2\2\u01cf\u01d0\7n\2\2\u01d0\u01d1\7h\2\2\u01d1\u01d2"+
		"\7G\2\2\u01d2\u01d3\7x\2\2\u01d3\u01d4\7g\2\2\u01d4\u01d5\7p\2\2\u01d5"+
		"f\3\2\2\2\u01d6\u01d7\7w\2\2\u01d7\u01d8\7p\2\2\u01d8\u01d9\7p\2\2\u01d9"+
		"\u01da\7g\2\2\u01da\u01db\7e\2\2\u01db\u01dc\7g\2\2\u01dc\u01dd\7u\2\2"+
		"\u01dd\u01de\7u\2\2\u01de\u01df\7c\2\2\u01df\u01e0\7t\2\2\u01e0\u01e1"+
		"\7{\2\2\u01e1h\3\2\2\2\u01e2\u01ec\5s:\2\u01e3\u01ec\5u;\2\u01e4\u01ec"+
		"\5w<\2\u01e5\u01ec\5\177@\2\u01e6\u01ec\5\u0081A\2\u01e7\u01ec\5\u0083"+
		"B\2\u01e8\u01ec\5\u008bF\2\u01e9\u01ec\5\u008dG\2\u01ea\u01ec\5\u008f"+
		"H\2\u01eb\u01e2\3\2\2\2\u01eb\u01e3\3\2\2\2\u01eb\u01e4\3\2\2\2\u01eb"+
		"\u01e5\3\2\2\2\u01eb\u01e6\3\2\2\2\u01eb\u01e7\3\2\2\2\u01eb\u01e8\3\2"+
		"\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ea\3\2\2\2\u01ecj\3\2\2\2\u01ed\u01f7"+
		"\5y=\2\u01ee\u01f7\5{>\2\u01ef\u01f7\5}?\2\u01f0\u01f7\5\u0085C\2\u01f1"+
		"\u01f7\5\u0087D\2\u01f2\u01f7\5\u0089E\2\u01f3\u01f7\5\u0091I\2\u01f4"+
		"\u01f7\5\u0093J\2\u01f5\u01f7\5\u0095K\2\u01f6\u01ed\3\2\2\2\u01f6\u01ee"+
		"\3\2\2\2\u01f6\u01ef\3\2\2\2\u01f6\u01f0\3\2\2\2\u01f6\u01f1\3\2\2\2\u01f6"+
		"\u01f2\3\2\2\2\u01f6\u01f3\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f5\3\2"+
		"\2\2\u01f7l\3\2\2\2\u01f8\u01f9\7e\2\2\u01f9\u01fa\7w\2\2\u01fa\u01fb"+
		"\7t\2\2\u01fb\u01fc\7t\2\2\u01fc\u01fd\7F\2\2\u01fd\u01fe\7c\2\2\u01fe"+
		"\u01ff\7v\2\2\u01ff\u0200\7g\2\2\u0200n\3\2\2\2\u0201\u0202\7e\2\2\u0202"+
		"\u0203\7w\2\2\u0203\u0204\7t\2\2\u0204\u0205\7t\2\2\u0205\u0206\7V\2\2"+
		"\u0206\u0207\7k\2\2\u0207\u0208\7o\2\2\u0208\u0209\7g\2\2\u0209p\3\2\2"+
		"\2\u020a\u020b\7e\2\2\u020b\u020c\7w\2\2\u020c\u020d\7t\2\2\u020d\u020e"+
		"\7t\2\2\u020e\u020f\7F\2\2\u020f\u0210\7c\2\2\u0210\u0211\7v\2\2\u0211"+
		"\u0212\7g\2\2\u0212\u0213\7V\2\2\u0213\u0214\7k\2\2\u0214\u0215\7o\2\2"+
		"\u0215\u0216\7g\2\2\u0216r\3\2\2\2\u0217\u0218\7r\2\2\u0218\u0219\7n\2"+
		"\2\u0219\u021a\7w\2\2\u021a\u021b\7u\2\2\u021b\u021c\7F\2\2\u021c\u021d"+
		"\7c\2\2\u021d\u021e\7{\2\2\u021e\u021f\7u\2\2\u021ft\3\2\2\2\u0220\u0221"+
		"\7r\2\2\u0221\u0222\7n\2\2\u0222\u0223\7w\2\2\u0223\u0224\7u\2\2\u0224"+
		"\u0225\7O\2\2\u0225\u0226\7q\2\2\u0226\u0227\7p\2\2\u0227\u0228\7v\2\2"+
		"\u0228\u0229\7j\2\2\u0229\u022a\7u\2\2\u022av\3\2\2\2\u022b\u022c\7r\2"+
		"\2\u022c\u022d\7n\2\2\u022d\u022e\7w\2\2\u022e\u022f\7u\2\2\u022f\u0230"+
		"\7[\2\2\u0230\u0231\7g\2\2\u0231\u0232\7c\2\2\u0232\u0233\7t\2\2\u0233"+
		"\u0234\7u\2\2\u0234x\3\2\2\2\u0235\u0236\7r\2\2\u0236\u0237\7n\2\2\u0237"+
		"\u0238\7w\2\2\u0238\u0239\7u\2\2\u0239\u023a\7J\2\2\u023a\u023b\7q\2\2"+
		"\u023b\u023c\7w\2\2\u023c\u023d\7t\2\2\u023d\u023e\7u\2\2\u023ez\3\2\2"+
		"\2\u023f\u0240\7r\2\2\u0240\u0241\7n\2\2\u0241\u0242\7w\2\2\u0242\u0243"+
		"\7u\2\2\u0243\u0244\7O\2\2\u0244\u0245\7k\2\2\u0245\u0246\7p\2\2\u0246"+
		"\u0247\7w\2\2\u0247\u0248\7v\2\2\u0248\u0249\7g\2\2\u0249\u024a\7u\2\2"+
		"\u024a|\3\2\2\2\u024b\u024c\7r\2\2\u024c\u024d\7n\2\2\u024d\u024e\7w\2"+
		"\2\u024e\u024f\7u\2\2\u024f\u0250\7U\2\2\u0250\u0251\7g\2\2\u0251\u0252"+
		"\7e\2\2\u0252\u0253\7q\2\2\u0253\u0254\7p\2\2\u0254\u0255\7f\2\2\u0255"+
		"\u0256\7u\2\2\u0256~\3\2\2\2\u0257\u0258\7o\2\2\u0258\u0259\7k\2\2\u0259"+
		"\u025a\7p\2\2\u025a\u025b\7w\2\2\u025b\u025c\7u\2\2\u025c\u025d\7F\2\2"+
		"\u025d\u025e\7c\2\2\u025e\u025f\7{\2\2\u025f\u0260\7u\2\2\u0260\u0080"+
		"\3\2\2\2\u0261\u0262\7o\2\2\u0262\u0263\7k\2\2\u0263\u0264\7p\2\2\u0264"+
		"\u0265\7w\2\2\u0265\u0266\7u\2\2\u0266\u0267\7O\2\2\u0267\u0268\7q\2\2"+
		"\u0268\u0269\7p\2\2\u0269\u026a\7v\2\2\u026a\u026b\7j\2\2\u026b\u026c"+
		"\7u\2\2\u026c\u0082\3\2\2\2\u026d\u026e\7o\2\2\u026e\u026f\7k\2\2\u026f"+
		"\u0270\7p\2\2\u0270\u0271\7w\2\2\u0271\u0272\7u\2\2\u0272\u0273\7[\2\2"+
		"\u0273\u0274\7g\2\2\u0274\u0275\7c\2\2\u0275\u0276\7t\2\2\u0276\u0277"+
		"\7u\2\2\u0277\u0084\3\2\2\2\u0278\u0279\7o\2\2\u0279\u027a\7k\2\2\u027a"+
		"\u027b\7p\2\2\u027b\u027c\7w\2\2\u027c\u027d\7u\2\2\u027d\u027e\7J\2\2"+
		"\u027e\u027f\7q\2\2\u027f\u0280\7w\2\2\u0280\u0281\7t\2\2\u0281\u0282"+
		"\7u\2\2\u0282\u0086\3\2\2\2\u0283\u0284\7o\2\2\u0284\u0285\7k\2\2\u0285"+
		"\u0286\7p\2\2\u0286\u0287\7w\2\2\u0287\u0288\7u\2\2\u0288\u0289\7O\2\2"+
		"\u0289\u028a\7k\2\2\u028a\u028b\7p\2\2\u028b\u028c\7w\2\2\u028c\u028d"+
		"\7v\2\2\u028d\u028e\7g\2\2\u028e\u028f\7u\2\2\u028f\u0088\3\2\2\2\u0290"+
		"\u0291\7o\2\2\u0291\u0292\7k\2\2\u0292\u0293\7p\2\2\u0293\u0294\7w\2\2"+
		"\u0294\u0295\7u\2\2\u0295\u0296\7U\2\2\u0296\u0297\7g\2\2\u0297\u0298"+
		"\7e\2\2\u0298\u0299\7q\2\2\u0299\u029a\7p\2\2\u029a\u029b\7f\2\2\u029b"+
		"\u029c\7u\2\2\u029c\u008a\3\2\2\2\u029d\u029e\7u\2\2\u029e\u029f\7g\2"+
		"\2\u029f\u02a0\7v\2\2\u02a0\u02a1\7F\2\2\u02a1\u02a2\7c\2\2\u02a2\u02a3"+
		"\7{\2\2\u02a3\u02a4\7u\2\2\u02a4\u008c\3\2\2\2\u02a5\u02a6\7u\2\2\u02a6"+
		"\u02a7\7g\2\2\u02a7\u02a8\7v\2\2\u02a8\u02a9\7O\2\2\u02a9\u02aa\7q\2\2"+
		"\u02aa\u02ab\7p\2\2\u02ab\u02ac\7v\2\2\u02ac\u02ad\7j\2\2\u02ad\u02ae"+
		"\7u\2\2\u02ae\u008e\3\2\2\2\u02af\u02b0\7u\2\2\u02b0\u02b1\7g\2\2\u02b1"+
		"\u02b2\7v\2\2\u02b2\u02b3\7[\2\2\u02b3\u02b4\7g\2\2\u02b4\u02b5\7c\2\2"+
		"\u02b5\u02b6\7t\2\2\u02b6\u02b7\7u\2\2\u02b7\u0090\3\2\2\2\u02b8\u02b9"+
		"\7u\2\2\u02b9\u02ba\7g\2\2\u02ba\u02bb\7v\2\2\u02bb\u02bc\7J\2\2\u02bc"+
		"\u02bd\7q\2\2\u02bd\u02be\7w\2\2\u02be\u02bf\7t\2\2\u02bf\u02c0\7u\2\2"+
		"\u02c0\u0092\3\2\2\2\u02c1\u02c2\7u\2\2\u02c2\u02c3\7g\2\2\u02c3\u02c4"+
		"\7v\2\2\u02c4\u02c5\7O\2\2\u02c5\u02c6\7k\2\2\u02c6\u02c7\7p\2\2\u02c7"+
		"\u02c8\7w\2\2\u02c8\u02c9\7v\2\2\u02c9\u02ca\7g\2\2\u02ca\u02cb\7u\2\2"+
		"\u02cb\u0094\3\2\2\2\u02cc\u02cd\7u\2\2\u02cd\u02ce\7g\2\2\u02ce\u02cf"+
		"\7v\2\2\u02cf\u02d0\7U\2\2\u02d0\u02d1\7g\2\2\u02d1\u02d2\7e\2\2\u02d2"+
		"\u02d3\7q\2\2\u02d3\u02d4\7p\2\2\u02d4\u02d5\7f\2\2\u02d5\u02d6\7u\2\2"+
		"\u02d6\u0096\3\2\2\2\u02d7\u02d8\7*\2\2\u02d8\u0098\3\2\2\2\u02d9\u02da"+
		"\7+\2\2\u02da\u009a\3\2\2\2\u02db\u02dc\7]\2\2\u02dc\u009c\3\2\2\2\u02dd"+
		"\u02de\7_\2\2\u02de\u009e\3\2\2\2\u02df\u02e0\7)\2\2\u02e0\u00a0\3\2\2"+
		"\2\u02e1\u02e2\7<\2\2\u02e2\u02e3\7?\2\2\u02e3\u00a2\3\2\2\2\u02e4\u02e5"+
		"\7.\2\2\u02e5\u00a4\3\2\2\2\u02e6\u02e7\7=\2\2\u02e7\u00a6\3\2\2\2\u02e8"+
		"\u02e9\7\60\2\2\u02e9\u00a8\3\2\2\2\u02ea\u02eb\7e\2\2\u02eb\u02ec\7q"+
		"\2\2\u02ec\u02ed\7p\2\2\u02ed\u02ee\7v\2\2\u02ee\u02ef\7c\2\2\u02ef\u02f0"+
		"\7k\2\2\u02f0\u02f1\7p\2\2\u02f1\u02f2\7u\2\2\u02f2\u00aa\3\2\2\2\u02f3"+
		"\u02f4\7\60\2\2\u02f4\u02f5\7&\2\2\u02f5\u02f6\7\60\2\2\u02f6\u02f7\3"+
		"\2\2\2\u02f7\u02f8\5\u00efx\2\u02f8\u00ac\3\2\2\2\u02f9\u02fa\7&\2\2\u02fa"+
		"\u02fb\7\60\2\2\u02fb\u00ae\3\2\2\2\u02fc\u02fd\5\u00d7l\2\u02fd\u00b0"+
		"\3\2\2\2\u02fe\u02ff\5\u00d9m\2\u02ff\u0300\5\u00d7l\2\u0300\u00b2\3\2"+
		"\2\2\u0301\u0305\5\u009fP\2\u0302\u0304\n\2\2\2\u0303\u0302\3\2\2\2\u0304"+
		"\u0307\3\2\2\2\u0305\u0303\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u0308\3\2"+
		"\2\2\u0307\u0305\3\2\2\2\u0308\u0309\5\u009fP\2\u0309\u00b4\3\2\2\2\u030a"+
		"\u030e\5\u00dbn\2\u030b\u030e\5\u00dfp\2\u030c\u030e\5\u00e1q\2\u030d"+
		"\u030a\3\2\2\2\u030d\u030b\3\2\2\2\u030d\u030c\3\2\2\2\u030e\u00b6\3\2"+
		"\2\2\u030f\u0310\5\u00ddo\2\u0310\u00b8\3\2\2\2\u0311\u0312\5\u00e7t\2"+
		"\u0312\u0313\5\u00e7t\2\u0313\u0314\5\u00e7t\2\u0314\u0315\5\u00e7t\2"+
		"\u0315\u0316\5#\22\2\u0316\u0317\5\u00cfh\2\u0317\u0318\5#\22\2\u0318"+
		"\u0319\5\u00cdg\2\u0319\u00ba\3\2\2\2\u031a\u031b\5\u00d1i\2\u031b\u031c"+
		"\5\u00e9u\2\u031c\u0320\5\u00d3j\2\u031d\u031e\5\u00e9u\2\u031e\u031f"+
		"\5\u00d3j\2\u031f\u0321\3\2\2\2\u0320\u031d\3\2\2\2\u0320\u0321\3\2\2"+
		"\2\u0321\u00bc\3\2\2\2\u0322\u0323\5\u00b9]\2\u0323\u0324\7V\2\2\u0324"+
		"\u0326\5\u00bb^\2\u0325\u0327\5\u00d5k\2\u0326\u0325\3\2\2\2\u0326\u0327"+
		"\3\2\2\2\u0327\u00be\3\2\2\2\u0328\u0329\7>\2\2\u0329\u032a\7d\2\2\u032a"+
		"\u032b\7q\2\2\u032b\u032c\7q\2\2\u032c\u032d\7n\2\2\u032d\u032e\7@\2\2"+
		"\u032e\u00c0\3\2\2\2\u032f\u0330\7>\2\2\u0330\u0331\7p\2\2\u0331\u0332"+
		"\7w\2\2\u0332\u0333\7o\2\2\u0333\u0334\7d\2\2\u0334\u0335\7g\2\2\u0335"+
		"\u0336\7t\2\2\u0336\u0337\7@\2\2\u0337\u00c2\3\2\2\2\u0338\u0339\7>\2"+
		"\2\u0339\u033a\7v\2\2\u033a\u033b\7g\2\2\u033b\u033c\7z\2\2\u033c\u033d"+
		"\7v\2\2\u033d\u033e\7@\2\2\u033e\u00c4\3\2\2\2\u033f\u0340\7>\2\2\u0340"+
		"\u0341\7f\2\2\u0341\u0342\7c\2\2\u0342\u0343\7v\2\2\u0343\u0344\7g\2\2"+
		"\u0344\u0345\7@\2\2\u0345\u00c6\3\2\2\2\u0346\u0347\7>\2\2\u0347\u0348"+
		"\7v\2\2\u0348\u0349\7k\2\2\u0349\u034a\7o\2\2\u034a\u034b\7g\2\2\u034b"+
		"\u034c\7@\2\2\u034c\u00c8\3\2\2\2\u034d\u034e\7>\2\2\u034e\u034f\7f\2"+
		"\2\u034f\u0350\7c\2\2\u0350\u0351\7v\2\2\u0351\u0352\7g\2\2\u0352\u0353"+
		"\7v\2\2\u0353\u0354\7k\2\2\u0354\u0355\7o\2\2\u0355\u0356\7g\2\2\u0356"+
		"\u0357\7@\2\2\u0357\u00ca\3\2\2\2\u0358\u0359\7>\2\2\u0359\u035a\7n\2"+
		"\2\u035a\u035b\7k\2\2\u035b\u035c\7u\2\2\u035c\u035d\7v\2\2\u035d\u035e"+
		"\7@\2\2\u035e\u00cc\3\2\2\2\u035f\u0360\7\62\2\2\u0360\u0366\4\63;\2\u0361"+
		"\u0362\4\63\64\2\u0362\u0366\5\u00e7t\2\u0363\u0364\7\65\2\2\u0364\u0366"+
		"\4\62\63\2\u0365\u035f\3\2\2\2\u0365\u0361\3\2\2\2\u0365\u0363\3\2\2\2"+
		"\u0366\u00ce\3\2\2\2\u0367\u0368\7\62\2\2\u0368\u036c\4\63;\2\u0369\u036a"+
		"\7\63\2\2\u036a\u036c\4\62\64\2\u036b\u0367\3\2\2\2\u036b\u0369\3\2\2"+
		"\2\u036c\u00d0\3\2\2\2\u036d\u036e\4\62\63\2\u036e\u0372\5\u00e7t\2\u036f"+
		"\u0370\7\64\2\2\u0370\u0372\4\62\65\2\u0371\u036d\3\2\2\2\u0371\u036f"+
		"\3\2\2\2\u0372\u00d2\3\2\2\2\u0373\u0374\4\62\67\2\u0374\u0375\5\u00e7"+
		"t\2\u0375\u00d4\3\2\2\2\u0376\u0377\t\3\2\2\u0377\u0378\4\62\64\2\u0378"+
		"\u0379\5\u00e7t\2\u0379\u037a\7<\2\2\u037a\u037b\5\u00e7t\2\u037b\u037c"+
		"\5\u00e7t\2\u037c\u00d6\3\2\2\2\u037d\u0381\t\4\2\2\u037e\u0380\t\5\2"+
		"\2\u037f\u037e\3\2\2\2\u0380\u0383\3\2\2\2\u0381\u037f\3\2\2\2\u0381\u0382"+
		"\3\2\2\2\u0382\u00d8\3\2\2\2\u0383\u0381\3\2\2\2\u0384\u0385\7/\2\2\u0385"+
		"\u00da\3\2\2\2\u0386\u0388\5\u00d9m\2\u0387\u0386\3\2\2\2\u0387\u0388"+
		"\3\2\2\2\u0388\u038a\3\2\2\2\u0389\u038b\t\6\2\2\u038a\u0389\3\2\2\2\u038b"+
		"\u038c\3\2\2\2\u038c\u038a\3\2\2\2\u038c\u038d\3\2\2\2\u038d\u0394\3\2"+
		"\2\2\u038e\u0390\7\60\2\2\u038f\u0391\t\6\2\2\u0390\u038f\3\2\2\2\u0391"+
		"\u0392\3\2\2\2\u0392\u0390\3\2\2\2\u0392\u0393\3\2\2\2\u0393\u0395\3\2"+
		"\2\2\u0394\u038e\3\2\2\2\u0394\u0395\3\2\2\2\u0395\u00dc\3\2\2\2\u0396"+
		"\u0398\t\6\2\2\u0397\u0396\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u0397\3\2"+
		"\2\2\u0399\u039a\3\2\2\2\u039a\u00de\3\2\2\2\u039b\u039d\7\62\2\2\u039c"+
		"\u039e\4\629\2\u039d\u039c\3\2\2\2\u039e\u039f\3\2\2\2\u039f\u039d\3\2"+
		"\2\2\u039f\u03a0\3\2\2\2\u03a0\u00e0\3\2\2\2\u03a1\u03a2\7\62\2\2\u03a2"+
		"\u03a3\7z\2\2\u03a3\u03a5\3\2\2\2\u03a4\u03a6\t\7\2\2\u03a5\u03a4\3\2"+
		"\2\2\u03a6\u03a7\3\2\2\2\u03a7\u03a5\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8"+
		"\u00e2\3\2\2\2\u03a9\u03aa\t\4\2\2\u03aa\u00e4\3\2\2\2\u03ab\u03af\t\b"+
		"\2\2\u03ac\u03af\5\u00e7t\2\u03ad\u03af\7a\2\2\u03ae\u03ab\3\2\2\2\u03ae"+
		"\u03ac\3\2\2\2\u03ae\u03ad\3\2\2\2\u03af\u00e6\3\2\2\2\u03b0\u03b1\4\62"+
		";\2\u03b1\u00e8\3\2\2\2\u03b2\u03b3\7<\2\2\u03b3\u00ea\3\2\2\2\u03b4\u03b5"+
		"\7\61\2\2\u03b5\u00ec\3\2\2\2\u03b6\u03b7\7/\2\2\u03b7\u03b8\7@\2\2\u03b8"+
		"\u00ee\3\2\2\2\u03b9\u03ba\7^\2\2\u03ba\u03bd\t\t\2\2\u03bb\u03bd\n\n"+
		"\2\2\u03bc\u03b9\3\2\2\2\u03bc\u03bb\3\2\2\2\u03bd\u03be\3\2\2\2\u03be"+
		"\u03bc\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\u00f0\3\2\2\2\u03c0\u03c1\7^"+
		"\2\2\u03c1\u03c4\t\t\2\2\u03c2\u03c4\n\13\2\2\u03c3\u03c0\3\2\2\2\u03c3"+
		"\u03c2\3\2\2\2\u03c4\u03c5\3\2\2\2\u03c5\u03c3\3\2\2\2\u03c5\u03c6\3\2"+
		"\2\2\u03c6\u00f2\3\2\2\2\u03c7\u03c8\7/\2\2\u03c8\u03c9\7*\2\2\u03c9\u00f4"+
		"\3\2\2\2\u03ca\u03cb\7\61\2\2\u03cb\u03cc\7\61\2\2\u03cc\u03d0\3\2\2\2"+
		"\u03cd\u03cf\n\f\2\2\u03ce\u03cd\3\2\2\2\u03cf\u03d2\3\2\2\2\u03d0\u03ce"+
		"\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03d4\3\2\2\2\u03d2\u03d0\3\2\2\2\u03d3"+
		"\u03d5\7\17\2\2\u03d4\u03d3\3\2\2\2\u03d4\u03d5\3\2\2\2\u03d5\u03d6\3"+
		"\2\2\2\u03d6\u03e4\7\f\2\2\u03d7\u03d8\7\61\2\2\u03d8\u03d9\7,\2\2\u03d9"+
		"\u03dd\3\2\2\2\u03da\u03dc\13\2\2\2\u03db\u03da\3\2\2\2\u03dc\u03df\3"+
		"\2\2\2\u03dd\u03de\3\2\2\2\u03dd\u03db\3\2\2\2\u03de\u03e0\3\2\2\2\u03df"+
		"\u03dd\3\2\2\2\u03e0\u03e1\7,\2\2\u03e1\u03e4\7\61\2\2\u03e2\u03e4\7\2"+
		"\2\3\u03e3\u03ca\3\2\2\2\u03e3\u03d7\3\2\2\2\u03e3\u03e2\3\2\2\2\u03e4"+
		"\u03e5\3\2\2\2\u03e5\u03e6\b{\2\2\u03e6\u00f6\3\2\2\2\u03e7\u03e9\t\r"+
		"\2\2\u03e8\u03e7\3\2\2\2\u03e9\u03ea\3\2\2\2\u03ea\u03e8\3\2\2\2\u03ea"+
		"\u03eb\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec\u03ed\b|\3\2\u03ed\u00f8\3\2"+
		"\2\2%\2\u014f\u0173\u0179\u017c\u018e\u01a0\u01a5\u01eb\u01f6\u0305\u030d"+
		"\u0320\u0326\u0365\u036b\u0371\u0381\u0387\u038c\u0392\u0394\u0399\u039f"+
		"\u03a7\u03ae\u03bc\u03be\u03c3\u03c5\u03d0\u03d4\u03dd\u03e3\u03ea\4\b"+
		"\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}