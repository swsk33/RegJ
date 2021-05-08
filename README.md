# RegJ使用说明
### 一个简易的、可以用java操作注册表的包。
#### 注意：注册表是系统重要数据，操作时请小心谨慎！
### 其功能有：
1，添加注册表项。<br>
2，删除注册表项。<br>
3，查询注册表项。<br>
4，从reg文件导入注册表项。<br>
5，把指定注册表项导出。<br>
### 下载地址:[点击进入下载jar包](https://gitee.com/swsk33/RegJ/releases)
## 使用方法：
### 1，添加依赖，有下列两种情况：
①Eclipse直接添加jar：先下载这个jar包并把这个包导入到IDE里面，例如eclipse。不知道如何导入请查看教程：[eclipse导入外部jar包](https://blog.csdn.net/czbqoo01/article/details/72803450)<br>
②Maven工程：在项目的配置文件pom.xml中的```<dependencies>```标签里加入下列依赖，此操作无需在上面手动下载jar包（推荐）：<br>
```
<dependency>
    <groupId>com.gitee.swsk33</groupId>
    <artifactId>reg-java</artifactId>
    <version>3.5.0</version>
</dependency>
```
### 2，导入com.gitee.swsk33.reg下所有类或者需要的类。
```
import com.gitee.swsk33.reg.*;
```
### 3，主要类与方法：
#### 类*RegAdd*：用于添加注册表项，其包含的方法：
* static boolean add(String primaryKey, String name)：在注册表里面添加空项
* static boolean add(String primaryKey, String name, String data)：在注册表里面添加项并指定其默认项的值，字符串值类型
* static boolean add(String primaryKey, String name, String type, String data)：在注册表里面添加项并指定其默认值的类型和值
* static boolean add(String primaryKey, String name, String type, String objectName, String data)：在注册表里面添加项并指定项中值的类型、名称和值（若该项已存在，则会在该项中添加值）
#### 类*RegDelete*：用于删除注册表项，其包含的方法：
* static boolean del(String primaryKey, String name)：删除注册表里面的某项及其所有子项
* static boolean del(String primaryKey, String name, String objectName)：删除注册表里面的某项的某个值
* static boolean delDefaultValue(String primaryKey, String name)：删除（清空）注册表里面的某项的默认值
#### 类*RegExport*：用于导出注册表项为reg文件，其包含的方法：
* static boolean export(String primaryKey, String name, String filePath)：导出注册表里面的某一项
#### 类*RegImport*：用于从reg注册表文件导入，其包含的方法：
* static void importReg(String filePath)：从注册表文件(reg文件)导入注册表
#### 类*RegQuery*：用于从查询注册表，其包含的方法：
* static String query(String primaryKey, String name)：查询注册表下的某项及其所有值的名称、类型和值
* static String query(String primaryKey, String name, String objectName)：查询注册表下的某项的值的信息
* static Map<String, Map<String, String>> queryValue(String primaryKey, String name)：精确查询注册表的值，查询注册表某一项的值及其子项的值
* static String queryValue(String primaryKey, String name, String objectName)：精确查询注册表的值，查询注册表某一项之下的值的值
* static String queryDefault(String primaryKey, String name)：查询注册表下的某项的默认值的信息
* static String queryDefaultValue(String primaryKey, String name)：精确查询注册表的值，查询注册表某一项默认值的值
* static boolean isRegExists(String primaryKey, String name)：判断注册表下的某一项是否存在
* static boolean isRegExists(String primaryKey, String name, String objectName)：判断注册表下的某一项的值是否存在
* static boolean isRegDefaultExists(String primaryKey, String name)：判断注册表下的某一项的默认值是有内容（不为空）<br>
**上述type（值的类型）参数可选常量对应如下：**<br>
```RegDataType.REG_SZ```:字符串值<br>
```RegDataType.REG_MULTI_SZ```:多字符串值<br>
```RegDataType.REG_EXPAND_SZ```:可扩展字符串值<br>
```RegDataType.REG_DWORD```:DWORD值<br>
```RegDataType.REG_QWORD```:QWORD值<br>
```RegDataType.REG_BINARY```:二进制值<br>
```RegDataType.REG_NONE```:无<br>
**上述primaryKey（注册表主键）参数可选常量对应如下：**<br>
RegPrimaryKey.HKCR:```HKEY_CLASSES_ROOT```<br>
RegPrimaryKey.HKCU:```HKEY_CURRENT_USER```<br>
RegPrimaryKey.HKLM:```HKEY_LOCAL_MACHINE```<br>
RegPrimaryKey.HKU:```HKEY_USERS```<br>
RegPrimaryKey.HKCC:```HKEY_CURRENT_CONFIG```<br>
<br>
**详细的使用可以在调用类的方法时查看，IDE中会显示其中的详细文档**<br>
### 实例
**例如给HKEY_CLASSES_ROOT里的AAM\shell里面加一个名为test的项:**<br>
```RegAdd.add(RegPrimaryKey.HKCR, "AAM\\shell\\test");```<br>
**例如给HKEY_CLASSES_ROOT里的AAM\shell里面加一个名为test的项,并指定其子项类型为字符串值且值为2333:**<br>
```RegAdd.add(RegPrimaryKey.HKCR, "AAM\\shell\\test", RegAdd.REG_SZ, "2333");```<br>
**注意：如果指定注册表存在，添加操作会将其覆盖！**<br>

**例如把HKEY_CLASSES_ROOT里的AAM\shell导出到E盘，保存为exp.reg:**<br>
```RegExport.export(RegPrimaryKey.HKCR, "AAM\\shell", "E:\\exp.reg");```<br>

**注意！若某项的值里面有"（双引号），请在方法参数中用\\\\\\"（三反斜杠加一个双引号）代替！单引号相同。**<br>
**若有\（反斜杠）,则用\\\\（两个反斜杠）代替！**<br>
**例如给HKEY_CLASSES_ROOT里的AAM\shell里面加一个名为test的项,并指定其子项类型为字符串值且值为\and":**<br>
```RegAdd.add(RegPrimaryKey.HKCR, "AAM\\shell\\test","REG_SZ","\\and\\\"");```<br>
>最后更新:2021.5.7