/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.openflamingo.remote.thrift.thriftfs.api;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Information that mirrors the "health report" information available on the
 * NameNode web UI
 */
public class DFSHealthReport implements org.apache.thrift.TBase<DFSHealthReport, DFSHealthReport._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DFSHealthReport");

  private static final org.apache.thrift.protocol.TField BYTES_TOTAL_FIELD_DESC = new org.apache.thrift.protocol.TField("bytesTotal", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField BYTES_USED_FIELD_DESC = new org.apache.thrift.protocol.TField("bytesUsed", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField BYTES_REMAINING_FIELD_DESC = new org.apache.thrift.protocol.TField("bytesRemaining", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField BYTES_NON_DFS_FIELD_DESC = new org.apache.thrift.protocol.TField("bytesNonDfs", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField NUM_LIVE_DATA_NODES_FIELD_DESC = new org.apache.thrift.protocol.TField("numLiveDataNodes", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField NUM_DEAD_DATA_NODES_FIELD_DESC = new org.apache.thrift.protocol.TField("numDeadDataNodes", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField UPGRADE_STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("upgradeStatus", org.apache.thrift.protocol.TType.STRUCT, (short)7);
  private static final org.apache.thrift.protocol.TField HTTP_PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("httpPort", org.apache.thrift.protocol.TType.I32, (short)8);

  public long bytesTotal;
  public long bytesUsed;
  public long bytesRemaining;
  public long bytesNonDfs;
  /**
   * How many datanodes are considered live
   */
  public int numLiveDataNodes;
  /**
   * How many datanodes are considered dead
   */
  public int numDeadDataNodes;
  /**
   * Status of the current running upgrade. If no upgrade
   * is running, this will be null.
   */
  public UpgradeStatusReport upgradeStatus;
  /**
   * The http port that the NameNode is listening on for its web UI
   * - this isn't really health, but it's related and handy
   */
  public int httpPort;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BYTES_TOTAL((short)1, "bytesTotal"),
    BYTES_USED((short)2, "bytesUsed"),
    BYTES_REMAINING((short)3, "bytesRemaining"),
    BYTES_NON_DFS((short)4, "bytesNonDfs"),
    /**
     * How many datanodes are considered live
     */
    NUM_LIVE_DATA_NODES((short)5, "numLiveDataNodes"),
    /**
     * How many datanodes are considered dead
     */
    NUM_DEAD_DATA_NODES((short)6, "numDeadDataNodes"),
    /**
     * Status of the current running upgrade. If no upgrade
     * is running, this will be null.
     */
    UPGRADE_STATUS((short)7, "upgradeStatus"),
    /**
     * The http port that the NameNode is listening on for its web UI
     * - this isn't really health, but it's related and handy
     */
    HTTP_PORT((short)8, "httpPort");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // BYTES_TOTAL
          return BYTES_TOTAL;
        case 2: // BYTES_USED
          return BYTES_USED;
        case 3: // BYTES_REMAINING
          return BYTES_REMAINING;
        case 4: // BYTES_NON_DFS
          return BYTES_NON_DFS;
        case 5: // NUM_LIVE_DATA_NODES
          return NUM_LIVE_DATA_NODES;
        case 6: // NUM_DEAD_DATA_NODES
          return NUM_DEAD_DATA_NODES;
        case 7: // UPGRADE_STATUS
          return UPGRADE_STATUS;
        case 8: // HTTP_PORT
          return HTTP_PORT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __BYTESTOTAL_ISSET_ID = 0;
  private static final int __BYTESUSED_ISSET_ID = 1;
  private static final int __BYTESREMAINING_ISSET_ID = 2;
  private static final int __BYTESNONDFS_ISSET_ID = 3;
  private static final int __NUMLIVEDATANODES_ISSET_ID = 4;
  private static final int __NUMDEADDATANODES_ISSET_ID = 5;
  private static final int __HTTPPORT_ISSET_ID = 6;
  private BitSet __isset_bit_vector = new BitSet(7);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BYTES_TOTAL, new org.apache.thrift.meta_data.FieldMetaData("bytesTotal", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.BYTES_USED, new org.apache.thrift.meta_data.FieldMetaData("bytesUsed", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.BYTES_REMAINING, new org.apache.thrift.meta_data.FieldMetaData("bytesRemaining", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.BYTES_NON_DFS, new org.apache.thrift.meta_data.FieldMetaData("bytesNonDfs", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.NUM_LIVE_DATA_NODES, new org.apache.thrift.meta_data.FieldMetaData("numLiveDataNodes", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NUM_DEAD_DATA_NODES, new org.apache.thrift.meta_data.FieldMetaData("numDeadDataNodes", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.UPGRADE_STATUS, new org.apache.thrift.meta_data.FieldMetaData("upgradeStatus", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, UpgradeStatusReport.class)));
    tmpMap.put(_Fields.HTTP_PORT, new org.apache.thrift.meta_data.FieldMetaData("httpPort", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DFSHealthReport.class, metaDataMap);
  }

  public DFSHealthReport() {
  }

  public DFSHealthReport(
    long bytesTotal,
    long bytesUsed,
    long bytesRemaining,
    long bytesNonDfs,
    int numLiveDataNodes,
    int numDeadDataNodes,
    UpgradeStatusReport upgradeStatus,
    int httpPort)
  {
    this();
    this.bytesTotal = bytesTotal;
    setBytesTotalIsSet(true);
    this.bytesUsed = bytesUsed;
    setBytesUsedIsSet(true);
    this.bytesRemaining = bytesRemaining;
    setBytesRemainingIsSet(true);
    this.bytesNonDfs = bytesNonDfs;
    setBytesNonDfsIsSet(true);
    this.numLiveDataNodes = numLiveDataNodes;
    setNumLiveDataNodesIsSet(true);
    this.numDeadDataNodes = numDeadDataNodes;
    setNumDeadDataNodesIsSet(true);
    this.upgradeStatus = upgradeStatus;
    this.httpPort = httpPort;
    setHttpPortIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DFSHealthReport(DFSHealthReport other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.bytesTotal = other.bytesTotal;
    this.bytesUsed = other.bytesUsed;
    this.bytesRemaining = other.bytesRemaining;
    this.bytesNonDfs = other.bytesNonDfs;
    this.numLiveDataNodes = other.numLiveDataNodes;
    this.numDeadDataNodes = other.numDeadDataNodes;
    if (other.isSetUpgradeStatus()) {
      this.upgradeStatus = new UpgradeStatusReport(other.upgradeStatus);
    }
    this.httpPort = other.httpPort;
  }

  public DFSHealthReport deepCopy() {
    return new DFSHealthReport(this);
  }

  @Override
  public void clear() {
    setBytesTotalIsSet(false);
    this.bytesTotal = 0;
    setBytesUsedIsSet(false);
    this.bytesUsed = 0;
    setBytesRemainingIsSet(false);
    this.bytesRemaining = 0;
    setBytesNonDfsIsSet(false);
    this.bytesNonDfs = 0;
    setNumLiveDataNodesIsSet(false);
    this.numLiveDataNodes = 0;
    setNumDeadDataNodesIsSet(false);
    this.numDeadDataNodes = 0;
    this.upgradeStatus = null;
    setHttpPortIsSet(false);
    this.httpPort = 0;
  }

  public long getBytesTotal() {
    return this.bytesTotal;
  }

  public DFSHealthReport setBytesTotal(long bytesTotal) {
    this.bytesTotal = bytesTotal;
    setBytesTotalIsSet(true);
    return this;
  }

  public void unsetBytesTotal() {
    __isset_bit_vector.clear(__BYTESTOTAL_ISSET_ID);
  }

  /** Returns true if field bytesTotal is set (has been assigned a value) and false otherwise */
  public boolean isSetBytesTotal() {
    return __isset_bit_vector.get(__BYTESTOTAL_ISSET_ID);
  }

  public void setBytesTotalIsSet(boolean value) {
    __isset_bit_vector.set(__BYTESTOTAL_ISSET_ID, value);
  }

  public long getBytesUsed() {
    return this.bytesUsed;
  }

  public DFSHealthReport setBytesUsed(long bytesUsed) {
    this.bytesUsed = bytesUsed;
    setBytesUsedIsSet(true);
    return this;
  }

  public void unsetBytesUsed() {
    __isset_bit_vector.clear(__BYTESUSED_ISSET_ID);
  }

  /** Returns true if field bytesUsed is set (has been assigned a value) and false otherwise */
  public boolean isSetBytesUsed() {
    return __isset_bit_vector.get(__BYTESUSED_ISSET_ID);
  }

  public void setBytesUsedIsSet(boolean value) {
    __isset_bit_vector.set(__BYTESUSED_ISSET_ID, value);
  }

  public long getBytesRemaining() {
    return this.bytesRemaining;
  }

  public DFSHealthReport setBytesRemaining(long bytesRemaining) {
    this.bytesRemaining = bytesRemaining;
    setBytesRemainingIsSet(true);
    return this;
  }

  public void unsetBytesRemaining() {
    __isset_bit_vector.clear(__BYTESREMAINING_ISSET_ID);
  }

  /** Returns true if field bytesRemaining is set (has been assigned a value) and false otherwise */
  public boolean isSetBytesRemaining() {
    return __isset_bit_vector.get(__BYTESREMAINING_ISSET_ID);
  }

  public void setBytesRemainingIsSet(boolean value) {
    __isset_bit_vector.set(__BYTESREMAINING_ISSET_ID, value);
  }

  public long getBytesNonDfs() {
    return this.bytesNonDfs;
  }

  public DFSHealthReport setBytesNonDfs(long bytesNonDfs) {
    this.bytesNonDfs = bytesNonDfs;
    setBytesNonDfsIsSet(true);
    return this;
  }

  public void unsetBytesNonDfs() {
    __isset_bit_vector.clear(__BYTESNONDFS_ISSET_ID);
  }

  /** Returns true if field bytesNonDfs is set (has been assigned a value) and false otherwise */
  public boolean isSetBytesNonDfs() {
    return __isset_bit_vector.get(__BYTESNONDFS_ISSET_ID);
  }

  public void setBytesNonDfsIsSet(boolean value) {
    __isset_bit_vector.set(__BYTESNONDFS_ISSET_ID, value);
  }

  /**
   * How many datanodes are considered live
   */
  public int getNumLiveDataNodes() {
    return this.numLiveDataNodes;
  }

  /**
   * How many datanodes are considered live
   */
  public DFSHealthReport setNumLiveDataNodes(int numLiveDataNodes) {
    this.numLiveDataNodes = numLiveDataNodes;
    setNumLiveDataNodesIsSet(true);
    return this;
  }

  public void unsetNumLiveDataNodes() {
    __isset_bit_vector.clear(__NUMLIVEDATANODES_ISSET_ID);
  }

  /** Returns true if field numLiveDataNodes is set (has been assigned a value) and false otherwise */
  public boolean isSetNumLiveDataNodes() {
    return __isset_bit_vector.get(__NUMLIVEDATANODES_ISSET_ID);
  }

  public void setNumLiveDataNodesIsSet(boolean value) {
    __isset_bit_vector.set(__NUMLIVEDATANODES_ISSET_ID, value);
  }

  /**
   * How many datanodes are considered dead
   */
  public int getNumDeadDataNodes() {
    return this.numDeadDataNodes;
  }

  /**
   * How many datanodes are considered dead
   */
  public DFSHealthReport setNumDeadDataNodes(int numDeadDataNodes) {
    this.numDeadDataNodes = numDeadDataNodes;
    setNumDeadDataNodesIsSet(true);
    return this;
  }

  public void unsetNumDeadDataNodes() {
    __isset_bit_vector.clear(__NUMDEADDATANODES_ISSET_ID);
  }

  /** Returns true if field numDeadDataNodes is set (has been assigned a value) and false otherwise */
  public boolean isSetNumDeadDataNodes() {
    return __isset_bit_vector.get(__NUMDEADDATANODES_ISSET_ID);
  }

  public void setNumDeadDataNodesIsSet(boolean value) {
    __isset_bit_vector.set(__NUMDEADDATANODES_ISSET_ID, value);
  }

  /**
   * Status of the current running upgrade. If no upgrade
   * is running, this will be null.
   */
  public UpgradeStatusReport getUpgradeStatus() {
    return this.upgradeStatus;
  }

  /**
   * Status of the current running upgrade. If no upgrade
   * is running, this will be null.
   */
  public DFSHealthReport setUpgradeStatus(UpgradeStatusReport upgradeStatus) {
    this.upgradeStatus = upgradeStatus;
    return this;
  }

  public void unsetUpgradeStatus() {
    this.upgradeStatus = null;
  }

  /** Returns true if field upgradeStatus is set (has been assigned a value) and false otherwise */
  public boolean isSetUpgradeStatus() {
    return this.upgradeStatus != null;
  }

  public void setUpgradeStatusIsSet(boolean value) {
    if (!value) {
      this.upgradeStatus = null;
    }
  }

  /**
   * The http port that the NameNode is listening on for its web UI
   * - this isn't really health, but it's related and handy
   */
  public int getHttpPort() {
    return this.httpPort;
  }

  /**
   * The http port that the NameNode is listening on for its web UI
   * - this isn't really health, but it's related and handy
   */
  public DFSHealthReport setHttpPort(int httpPort) {
    this.httpPort = httpPort;
    setHttpPortIsSet(true);
    return this;
  }

  public void unsetHttpPort() {
    __isset_bit_vector.clear(__HTTPPORT_ISSET_ID);
  }

  /** Returns true if field httpPort is set (has been assigned a value) and false otherwise */
  public boolean isSetHttpPort() {
    return __isset_bit_vector.get(__HTTPPORT_ISSET_ID);
  }

  public void setHttpPortIsSet(boolean value) {
    __isset_bit_vector.set(__HTTPPORT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BYTES_TOTAL:
      if (value == null) {
        unsetBytesTotal();
      } else {
        setBytesTotal((Long)value);
      }
      break;

    case BYTES_USED:
      if (value == null) {
        unsetBytesUsed();
      } else {
        setBytesUsed((Long)value);
      }
      break;

    case BYTES_REMAINING:
      if (value == null) {
        unsetBytesRemaining();
      } else {
        setBytesRemaining((Long)value);
      }
      break;

    case BYTES_NON_DFS:
      if (value == null) {
        unsetBytesNonDfs();
      } else {
        setBytesNonDfs((Long)value);
      }
      break;

    case NUM_LIVE_DATA_NODES:
      if (value == null) {
        unsetNumLiveDataNodes();
      } else {
        setNumLiveDataNodes((Integer)value);
      }
      break;

    case NUM_DEAD_DATA_NODES:
      if (value == null) {
        unsetNumDeadDataNodes();
      } else {
        setNumDeadDataNodes((Integer)value);
      }
      break;

    case UPGRADE_STATUS:
      if (value == null) {
        unsetUpgradeStatus();
      } else {
        setUpgradeStatus((UpgradeStatusReport)value);
      }
      break;

    case HTTP_PORT:
      if (value == null) {
        unsetHttpPort();
      } else {
        setHttpPort((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BYTES_TOTAL:
      return new Long(getBytesTotal());

    case BYTES_USED:
      return new Long(getBytesUsed());

    case BYTES_REMAINING:
      return new Long(getBytesRemaining());

    case BYTES_NON_DFS:
      return new Long(getBytesNonDfs());

    case NUM_LIVE_DATA_NODES:
      return new Integer(getNumLiveDataNodes());

    case NUM_DEAD_DATA_NODES:
      return new Integer(getNumDeadDataNodes());

    case UPGRADE_STATUS:
      return getUpgradeStatus();

    case HTTP_PORT:
      return new Integer(getHttpPort());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BYTES_TOTAL:
      return isSetBytesTotal();
    case BYTES_USED:
      return isSetBytesUsed();
    case BYTES_REMAINING:
      return isSetBytesRemaining();
    case BYTES_NON_DFS:
      return isSetBytesNonDfs();
    case NUM_LIVE_DATA_NODES:
      return isSetNumLiveDataNodes();
    case NUM_DEAD_DATA_NODES:
      return isSetNumDeadDataNodes();
    case UPGRADE_STATUS:
      return isSetUpgradeStatus();
    case HTTP_PORT:
      return isSetHttpPort();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof DFSHealthReport)
      return this.equals((DFSHealthReport)that);
    return false;
  }

  public boolean equals(DFSHealthReport that) {
    if (that == null)
      return false;

    boolean this_present_bytesTotal = true;
    boolean that_present_bytesTotal = true;
    if (this_present_bytesTotal || that_present_bytesTotal) {
      if (!(this_present_bytesTotal && that_present_bytesTotal))
        return false;
      if (this.bytesTotal != that.bytesTotal)
        return false;
    }

    boolean this_present_bytesUsed = true;
    boolean that_present_bytesUsed = true;
    if (this_present_bytesUsed || that_present_bytesUsed) {
      if (!(this_present_bytesUsed && that_present_bytesUsed))
        return false;
      if (this.bytesUsed != that.bytesUsed)
        return false;
    }

    boolean this_present_bytesRemaining = true;
    boolean that_present_bytesRemaining = true;
    if (this_present_bytesRemaining || that_present_bytesRemaining) {
      if (!(this_present_bytesRemaining && that_present_bytesRemaining))
        return false;
      if (this.bytesRemaining != that.bytesRemaining)
        return false;
    }

    boolean this_present_bytesNonDfs = true;
    boolean that_present_bytesNonDfs = true;
    if (this_present_bytesNonDfs || that_present_bytesNonDfs) {
      if (!(this_present_bytesNonDfs && that_present_bytesNonDfs))
        return false;
      if (this.bytesNonDfs != that.bytesNonDfs)
        return false;
    }

    boolean this_present_numLiveDataNodes = true;
    boolean that_present_numLiveDataNodes = true;
    if (this_present_numLiveDataNodes || that_present_numLiveDataNodes) {
      if (!(this_present_numLiveDataNodes && that_present_numLiveDataNodes))
        return false;
      if (this.numLiveDataNodes != that.numLiveDataNodes)
        return false;
    }

    boolean this_present_numDeadDataNodes = true;
    boolean that_present_numDeadDataNodes = true;
    if (this_present_numDeadDataNodes || that_present_numDeadDataNodes) {
      if (!(this_present_numDeadDataNodes && that_present_numDeadDataNodes))
        return false;
      if (this.numDeadDataNodes != that.numDeadDataNodes)
        return false;
    }

    boolean this_present_upgradeStatus = true && this.isSetUpgradeStatus();
    boolean that_present_upgradeStatus = true && that.isSetUpgradeStatus();
    if (this_present_upgradeStatus || that_present_upgradeStatus) {
      if (!(this_present_upgradeStatus && that_present_upgradeStatus))
        return false;
      if (!this.upgradeStatus.equals(that.upgradeStatus))
        return false;
    }

    boolean this_present_httpPort = true;
    boolean that_present_httpPort = true;
    if (this_present_httpPort || that_present_httpPort) {
      if (!(this_present_httpPort && that_present_httpPort))
        return false;
      if (this.httpPort != that.httpPort)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_bytesTotal = true;
    builder.append(present_bytesTotal);
    if (present_bytesTotal)
      builder.append(bytesTotal);

    boolean present_bytesUsed = true;
    builder.append(present_bytesUsed);
    if (present_bytesUsed)
      builder.append(bytesUsed);

    boolean present_bytesRemaining = true;
    builder.append(present_bytesRemaining);
    if (present_bytesRemaining)
      builder.append(bytesRemaining);

    boolean present_bytesNonDfs = true;
    builder.append(present_bytesNonDfs);
    if (present_bytesNonDfs)
      builder.append(bytesNonDfs);

    boolean present_numLiveDataNodes = true;
    builder.append(present_numLiveDataNodes);
    if (present_numLiveDataNodes)
      builder.append(numLiveDataNodes);

    boolean present_numDeadDataNodes = true;
    builder.append(present_numDeadDataNodes);
    if (present_numDeadDataNodes)
      builder.append(numDeadDataNodes);

    boolean present_upgradeStatus = true && (isSetUpgradeStatus());
    builder.append(present_upgradeStatus);
    if (present_upgradeStatus)
      builder.append(upgradeStatus);

    boolean present_httpPort = true;
    builder.append(present_httpPort);
    if (present_httpPort)
      builder.append(httpPort);

    return builder.toHashCode();
  }

  public int compareTo(DFSHealthReport other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    DFSHealthReport typedOther = (DFSHealthReport)other;

    lastComparison = Boolean.valueOf(isSetBytesTotal()).compareTo(typedOther.isSetBytesTotal());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBytesTotal()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bytesTotal, typedOther.bytesTotal);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBytesUsed()).compareTo(typedOther.isSetBytesUsed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBytesUsed()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bytesUsed, typedOther.bytesUsed);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBytesRemaining()).compareTo(typedOther.isSetBytesRemaining());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBytesRemaining()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bytesRemaining, typedOther.bytesRemaining);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBytesNonDfs()).compareTo(typedOther.isSetBytesNonDfs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBytesNonDfs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bytesNonDfs, typedOther.bytesNonDfs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNumLiveDataNodes()).compareTo(typedOther.isSetNumLiveDataNodes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNumLiveDataNodes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.numLiveDataNodes, typedOther.numLiveDataNodes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNumDeadDataNodes()).compareTo(typedOther.isSetNumDeadDataNodes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNumDeadDataNodes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.numDeadDataNodes, typedOther.numDeadDataNodes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUpgradeStatus()).compareTo(typedOther.isSetUpgradeStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUpgradeStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.upgradeStatus, typedOther.upgradeStatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHttpPort()).compareTo(typedOther.isSetHttpPort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHttpPort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.httpPort, typedOther.httpPort);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // BYTES_TOTAL
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.bytesTotal = iprot.readI64();
            setBytesTotalIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // BYTES_USED
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.bytesUsed = iprot.readI64();
            setBytesUsedIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // BYTES_REMAINING
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.bytesRemaining = iprot.readI64();
            setBytesRemainingIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // BYTES_NON_DFS
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.bytesNonDfs = iprot.readI64();
            setBytesNonDfsIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // NUM_LIVE_DATA_NODES
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.numLiveDataNodes = iprot.readI32();
            setNumLiveDataNodesIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // NUM_DEAD_DATA_NODES
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.numDeadDataNodes = iprot.readI32();
            setNumDeadDataNodesIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // UPGRADE_STATUS
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.upgradeStatus = new UpgradeStatusReport();
            this.upgradeStatus.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 8: // HTTP_PORT
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.httpPort = iprot.readI32();
            setHttpPortIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(BYTES_TOTAL_FIELD_DESC);
    oprot.writeI64(this.bytesTotal);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(BYTES_USED_FIELD_DESC);
    oprot.writeI64(this.bytesUsed);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(BYTES_REMAINING_FIELD_DESC);
    oprot.writeI64(this.bytesRemaining);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(BYTES_NON_DFS_FIELD_DESC);
    oprot.writeI64(this.bytesNonDfs);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(NUM_LIVE_DATA_NODES_FIELD_DESC);
    oprot.writeI32(this.numLiveDataNodes);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(NUM_DEAD_DATA_NODES_FIELD_DESC);
    oprot.writeI32(this.numDeadDataNodes);
    oprot.writeFieldEnd();
    if (this.upgradeStatus != null) {
      oprot.writeFieldBegin(UPGRADE_STATUS_FIELD_DESC);
      this.upgradeStatus.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(HTTP_PORT_FIELD_DESC);
    oprot.writeI32(this.httpPort);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("DFSHealthReport(");
    boolean first = true;

    sb.append("bytesTotal:");
    sb.append(this.bytesTotal);
    first = false;
    if (!first) sb.append(", ");
    sb.append("bytesUsed:");
    sb.append(this.bytesUsed);
    first = false;
    if (!first) sb.append(", ");
    sb.append("bytesRemaining:");
    sb.append(this.bytesRemaining);
    first = false;
    if (!first) sb.append(", ");
    sb.append("bytesNonDfs:");
    sb.append(this.bytesNonDfs);
    first = false;
    if (!first) sb.append(", ");
    sb.append("numLiveDataNodes:");
    sb.append(this.numLiveDataNodes);
    first = false;
    if (!first) sb.append(", ");
    sb.append("numDeadDataNodes:");
    sb.append(this.numDeadDataNodes);
    first = false;
    if (!first) sb.append(", ");
    sb.append("upgradeStatus:");
    if (this.upgradeStatus == null) {
      sb.append("null");
    } else {
      sb.append(this.upgradeStatus);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("httpPort:");
    sb.append(this.httpPort);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

