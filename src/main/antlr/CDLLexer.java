// Generated from src/main/antlr/CDL.g4 by ANTLR 4.13.1
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
		T__9=10, T__10=11, T__11=12, ID=13, STRING=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "ID", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'intent'", "'end'", "'rule'", "'policy'", "'flow'", "'mapping'", 
			"'->'", "':'", "'start'", "'then'", "'when'", "'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "STRING", "WS"
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
		"\u0004\u0000\u000ft\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0005\f^\b\f\n\f\f\fa\t\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\rg\b\r\n\r\f\rj\t\r\u0001\r\u0001\r\u0001\u000e\u0004"+
		"\u000eo\b\u000e\u000b\u000e\f\u000ep\u0001\u000e\u0001\u000e\u0000\u0000"+
		"\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u0001\u0000\u0004\u0002\u0000AZ__\u0003\u000009AZ__\u0002"+
		"\u0000\"\"\\\\\u0003\u0000\t\n\r\r  w\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0001\u001f"+
		"\u0001\u0000\u0000\u0000\u0003&\u0001\u0000\u0000\u0000\u0005*\u0001\u0000"+
		"\u0000\u0000\u0007/\u0001\u0000\u0000\u0000\t6\u0001\u0000\u0000\u0000"+
		"\u000b;\u0001\u0000\u0000\u0000\rC\u0001\u0000\u0000\u0000\u000fF\u0001"+
		"\u0000\u0000\u0000\u0011H\u0001\u0000\u0000\u0000\u0013N\u0001\u0000\u0000"+
		"\u0000\u0015S\u0001\u0000\u0000\u0000\u0017X\u0001\u0000\u0000\u0000\u0019"+
		"[\u0001\u0000\u0000\u0000\u001bb\u0001\u0000\u0000\u0000\u001dn\u0001"+
		"\u0000\u0000\u0000\u001f \u0005i\u0000\u0000 !\u0005n\u0000\u0000!\"\u0005"+
		"t\u0000\u0000\"#\u0005e\u0000\u0000#$\u0005n\u0000\u0000$%\u0005t\u0000"+
		"\u0000%\u0002\u0001\u0000\u0000\u0000&\'\u0005e\u0000\u0000\'(\u0005n"+
		"\u0000\u0000()\u0005d\u0000\u0000)\u0004\u0001\u0000\u0000\u0000*+\u0005"+
		"r\u0000\u0000+,\u0005u\u0000\u0000,-\u0005l\u0000\u0000-.\u0005e\u0000"+
		"\u0000.\u0006\u0001\u0000\u0000\u0000/0\u0005p\u0000\u000001\u0005o\u0000"+
		"\u000012\u0005l\u0000\u000023\u0005i\u0000\u000034\u0005c\u0000\u0000"+
		"45\u0005y\u0000\u00005\b\u0001\u0000\u0000\u000067\u0005f\u0000\u0000"+
		"78\u0005l\u0000\u000089\u0005o\u0000\u00009:\u0005w\u0000\u0000:\n\u0001"+
		"\u0000\u0000\u0000;<\u0005m\u0000\u0000<=\u0005a\u0000\u0000=>\u0005p"+
		"\u0000\u0000>?\u0005p\u0000\u0000?@\u0005i\u0000\u0000@A\u0005n\u0000"+
		"\u0000AB\u0005g\u0000\u0000B\f\u0001\u0000\u0000\u0000CD\u0005-\u0000"+
		"\u0000DE\u0005>\u0000\u0000E\u000e\u0001\u0000\u0000\u0000FG\u0005:\u0000"+
		"\u0000G\u0010\u0001\u0000\u0000\u0000HI\u0005s\u0000\u0000IJ\u0005t\u0000"+
		"\u0000JK\u0005a\u0000\u0000KL\u0005r\u0000\u0000LM\u0005t\u0000\u0000"+
		"M\u0012\u0001\u0000\u0000\u0000NO\u0005t\u0000\u0000OP\u0005h\u0000\u0000"+
		"PQ\u0005e\u0000\u0000QR\u0005n\u0000\u0000R\u0014\u0001\u0000\u0000\u0000"+
		"ST\u0005w\u0000\u0000TU\u0005h\u0000\u0000UV\u0005e\u0000\u0000VW\u0005"+
		"n\u0000\u0000W\u0016\u0001\u0000\u0000\u0000XY\u0005=\u0000\u0000YZ\u0005"+
		"=\u0000\u0000Z\u0018\u0001\u0000\u0000\u0000[_\u0007\u0000\u0000\u0000"+
		"\\^\u0007\u0001\u0000\u0000]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\u001a\u0001"+
		"\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bh\u0005\"\u0000\u0000cg\b"+
		"\u0002\u0000\u0000de\u0005\\\u0000\u0000eg\t\u0000\u0000\u0000fc\u0001"+
		"\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000"+
		"hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000"+
		"\u0000jh\u0001\u0000\u0000\u0000kl\u0005\"\u0000\u0000l\u001c\u0001\u0000"+
		"\u0000\u0000mo\u0007\u0003\u0000\u0000nm\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000rs\u0006\u000e\u0000\u0000s\u001e\u0001\u0000"+
		"\u0000\u0000\u0005\u0000_fhp\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}