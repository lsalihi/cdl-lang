// Generated from src/main/antlr/CDL.g4 by ANTLR 4.13.1

package com.cdl;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CDLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, LOWER_ID=16, 
		ID=17, STRING=18, NUMBER=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "LOWER_ID", "ID", 
			"STRING", "NUMBER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'intent'", "'end'", "'rule'", "'policy'", "'flow'", "'mapping'", 
			"'->'", "':'", "'['", "','", "']'", "'start'", "'then'", "'when'", "'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "LOWER_ID", "ID", "STRING", "NUMBER", "WS"
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


	public CDLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CDL.g4"; }

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
		"\u0004\u0000\u0014\u0098\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0005\u000fn\b\u000f\n\u000f\f\u000fq\t\u000f\u0001\u0010\u0001"+
		"\u0010\u0005\u0010u\b\u0010\n\u0010\f\u0010x\t\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011~\b\u0011\n\u0011\f\u0011\u0081"+
		"\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012\u0086\b\u0012"+
		"\u000b\u0012\f\u0012\u0087\u0001\u0012\u0001\u0012\u0004\u0012\u008c\b"+
		"\u0012\u000b\u0012\f\u0012\u008d\u0003\u0012\u0090\b\u0012\u0001\u0013"+
		"\u0004\u0013\u0093\b\u0013\u000b\u0013\f\u0013\u0094\u0001\u0013\u0001"+
		"\u0013\u0000\u0000\u0014\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014\u0001\u0000\u0007\u0002\u0000__az\u0003\u000009__az\u0002\u0000"+
		"AZ__\u0003\u000009AZ__\u0002\u0000\"\"\\\\\u0001\u000009\u0003\u0000\t"+
		"\n\r\r  \u009f\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0001)\u0001"+
		"\u0000\u0000\u0000\u00030\u0001\u0000\u0000\u0000\u00054\u0001\u0000\u0000"+
		"\u0000\u00079\u0001\u0000\u0000\u0000\t@\u0001\u0000\u0000\u0000\u000b"+
		"E\u0001\u0000\u0000\u0000\rM\u0001\u0000\u0000\u0000\u000fP\u0001\u0000"+
		"\u0000\u0000\u0011R\u0001\u0000\u0000\u0000\u0013T\u0001\u0000\u0000\u0000"+
		"\u0015V\u0001\u0000\u0000\u0000\u0017X\u0001\u0000\u0000\u0000\u0019^"+
		"\u0001\u0000\u0000\u0000\u001bc\u0001\u0000\u0000\u0000\u001dh\u0001\u0000"+
		"\u0000\u0000\u001fk\u0001\u0000\u0000\u0000!r\u0001\u0000\u0000\u0000"+
		"#y\u0001\u0000\u0000\u0000%\u0085\u0001\u0000\u0000\u0000\'\u0092\u0001"+
		"\u0000\u0000\u0000)*\u0005i\u0000\u0000*+\u0005n\u0000\u0000+,\u0005t"+
		"\u0000\u0000,-\u0005e\u0000\u0000-.\u0005n\u0000\u0000./\u0005t\u0000"+
		"\u0000/\u0002\u0001\u0000\u0000\u000001\u0005e\u0000\u000012\u0005n\u0000"+
		"\u000023\u0005d\u0000\u00003\u0004\u0001\u0000\u0000\u000045\u0005r\u0000"+
		"\u000056\u0005u\u0000\u000067\u0005l\u0000\u000078\u0005e\u0000\u0000"+
		"8\u0006\u0001\u0000\u0000\u00009:\u0005p\u0000\u0000:;\u0005o\u0000\u0000"+
		";<\u0005l\u0000\u0000<=\u0005i\u0000\u0000=>\u0005c\u0000\u0000>?\u0005"+
		"y\u0000\u0000?\b\u0001\u0000\u0000\u0000@A\u0005f\u0000\u0000AB\u0005"+
		"l\u0000\u0000BC\u0005o\u0000\u0000CD\u0005w\u0000\u0000D\n\u0001\u0000"+
		"\u0000\u0000EF\u0005m\u0000\u0000FG\u0005a\u0000\u0000GH\u0005p\u0000"+
		"\u0000HI\u0005p\u0000\u0000IJ\u0005i\u0000\u0000JK\u0005n\u0000\u0000"+
		"KL\u0005g\u0000\u0000L\f\u0001\u0000\u0000\u0000MN\u0005-\u0000\u0000"+
		"NO\u0005>\u0000\u0000O\u000e\u0001\u0000\u0000\u0000PQ\u0005:\u0000\u0000"+
		"Q\u0010\u0001\u0000\u0000\u0000RS\u0005[\u0000\u0000S\u0012\u0001\u0000"+
		"\u0000\u0000TU\u0005,\u0000\u0000U\u0014\u0001\u0000\u0000\u0000VW\u0005"+
		"]\u0000\u0000W\u0016\u0001\u0000\u0000\u0000XY\u0005s\u0000\u0000YZ\u0005"+
		"t\u0000\u0000Z[\u0005a\u0000\u0000[\\\u0005r\u0000\u0000\\]\u0005t\u0000"+
		"\u0000]\u0018\u0001\u0000\u0000\u0000^_\u0005t\u0000\u0000_`\u0005h\u0000"+
		"\u0000`a\u0005e\u0000\u0000ab\u0005n\u0000\u0000b\u001a\u0001\u0000\u0000"+
		"\u0000cd\u0005w\u0000\u0000de\u0005h\u0000\u0000ef\u0005e\u0000\u0000"+
		"fg\u0005n\u0000\u0000g\u001c\u0001\u0000\u0000\u0000hi\u0005=\u0000\u0000"+
		"ij\u0005=\u0000\u0000j\u001e\u0001\u0000\u0000\u0000ko\u0007\u0000\u0000"+
		"\u0000ln\u0007\u0001\u0000\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000"+
		"\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p \u0001"+
		"\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rv\u0007\u0002\u0000\u0000"+
		"su\u0007\u0003\u0000\u0000ts\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000"+
		"\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000w\"\u0001\u0000"+
		"\u0000\u0000xv\u0001\u0000\u0000\u0000y\u007f\u0005\"\u0000\u0000z~\b"+
		"\u0004\u0000\u0000{|\u0005\\\u0000\u0000|~\t\u0000\u0000\u0000}z\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000"+
		"\u0080\u0082\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0005\"\u0000\u0000\u0083$\u0001\u0000\u0000\u0000\u0084"+
		"\u0086\u0007\u0005\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0001\u0000\u0000\u0000\u0088\u008f\u0001\u0000\u0000\u0000\u0089"+
		"\u008b\u0005.\u0000\u0000\u008a\u008c\u0007\u0005\u0000\u0000\u008b\u008a"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090"+
		"\u0001\u0000\u0000\u0000\u008f\u0089\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0001\u0000\u0000\u0000\u0090&\u0001\u0000\u0000\u0000\u0091\u0093\u0007"+
		"\u0006\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001"+
		"\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0006"+
		"\u0013\u0000\u0000\u0097(\u0001\u0000\u0000\u0000\t\u0000ov}\u007f\u0087"+
		"\u008d\u008f\u0094\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}