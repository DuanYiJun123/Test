package qqduan.test.process;

import java.util.HashMap;
import java.util.Map;

import qqduan.test.cases.TestCase;
import qqduan.test.cases.TestCase2;
import qqduan.test.core.AbsProcessGroup;
import qqduan.test.core.ProcessChain;
import qqduan.test.interfac.ChainBefore;
import qqduan.test.interfac.GroupAfter;
import qqduan.test.interfac.GroupBefore;

public class TestProcess extends AbsProcessGroup {

	public TestProcess(ProcessChain tmplate) {
		super(tmplate);
		tmplate = new TestCase("test").afterCase(new TestCase2("test2")).commitChain();
	}

	@Override
	public void setData(Map<String, Map<String, Map<String, String>>> groupInparam,
			Map<String, Map<String, Map<String, String>>> groupExparam) {
		groupInparam = new HashMap<>();
		groupExparam = new HashMap<>();

		Map<String, String> caseInparam = new HashMap<>();
		caseInparam.put("app_id", "user");
		caseInparam.put("app_secret", "12345");

		Map<String, Map<String, String>> chainParam = new HashMap<>();
		chainParam.put("caseName", caseInparam);
		groupInparam.put("chainName", chainParam);
		
	}

}