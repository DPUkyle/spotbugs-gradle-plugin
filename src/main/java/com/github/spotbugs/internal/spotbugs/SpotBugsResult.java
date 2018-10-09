package com.github.spotbugs.internal.spotbugs;

import java.io.Serializable;

public class SpotBugsResult implements Serializable {
  private static final long serialVersionUID = 1L;
  private int bugCount;
  private int missingClassCount;
  private int errorCount;
  private Throwable exception;

  public SpotBugsResult(int bugCount, int missingClassCount, int errorCount) {
      this(bugCount, missingClassCount, errorCount, null);
  }

  public SpotBugsResult(int bugCount, int missingClassCount, int errorCount, Throwable exception) {
      this.bugCount = bugCount;
      this.missingClassCount = missingClassCount;
      this.errorCount = errorCount;
      this.exception = exception;
  }

  public int getBugCount() {
      return bugCount;
  }

  public void setBugCount(int bugCount) {
    this.bugCount = bugCount;
  }

  public int getMissingClassCount() {
      return missingClassCount;
  }

  public void setMissingClassCount(int missingClassCount) {
    this.missingClassCount = missingClassCount;
  }

  public int getErrorCount() {
      return errorCount;
  }

  public void setErrorCount(int errorCount) {
    this.errorCount = errorCount;
  }

  public Throwable getException() {
      return exception;
  }

  public void setException(Throwable exception) {
    this.exception = exception;
  }
}