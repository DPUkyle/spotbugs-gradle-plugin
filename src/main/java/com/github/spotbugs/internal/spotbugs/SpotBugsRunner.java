package com.github.spotbugs.internal.spotbugs;

import edu.umd.cs.findbugs.FindBugs;
import edu.umd.cs.findbugs.FindBugs2;
import edu.umd.cs.findbugs.IFindBugsEngine;
import edu.umd.cs.findbugs.TextUICommandLine;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;


public class SpotBugsRunner implements Runnable {
  private final SpotBugsSpec spec;
  private final SpotBugsResult result;

  @Inject
  SpotBugsRunner(SpotBugsSpec spec, SpotBugsResult result) {
    this.spec = spec;
    this.result = result;
  }

  @Override
  public void run() {
    final List<String> args = spec.getArguments();
    String[] strArray = args.toArray(new String[0]);
    FindBugs2 findBugs2 = new FindBugs2();
    TextUICommandLine commandLine = new TextUICommandLine();

    try {
      FindBugs.processCommandLine(commandLine, strArray, findBugs2);
      findBugs2.execute();

      populateSpotbugsResult(findBugs2, result);
    } catch (IOException | InterruptedException e) {
        throw new RuntimeException(e);
    }
  }

  private void populateSpotbugsResult(IFindBugsEngine findBugs, SpotBugsResult result) {
    result.setBugCount(findBugs.getBugCount());
    result.setMissingClassCount(findBugs.getMissingClassCount());
    result.setErrorCount(findBugs.getErrorCount());
  }

}
