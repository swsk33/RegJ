# RegJ使用说明
### 一个简易的、可以用java操作注册表的包。
### 其功能有：
1，添加注册表项。<br>
2，删除注册表项。<br>
3，查询注册表项。<br>
4，从reg文件导入注册表项。<br>
5，把指定注册表项导出。<br>
### 下载地址:[点击进入下载jar包](https://gitee.com/swsk33/RegJ/releases)
## 使用方法：
### 1，先把这个包导入到IDE里面，例如eclipse。不知道如何导入请查看教程：[eclipse导入外部jar包](https://blog.csdn.net/czbqoo01/article/details/72803450)
### 2，导入swsk33.Reg下所有类或者需要的类。（import swsk33.Reg.*;）
### 3，语法：
**说在最前：下面语法示例中用了最快捷的方法去执行了某个类中的某个方法。**<br>
**实际上这两种方式执行效果相同：**<br>
**方式一：**<br>
```A a=new A();```<br>
```a.af();```<br>
**方式二:**<br>
```new A().af();```<br>
**上述方式一、二效果相同，都是执行了A类里的af方法。只是方法一先生成了对象。下面示例基本上用方法二进行演示。**<br>
------------------------------------------------------------------------------------------------------------------------------
#### (1)添加注册表项：
##### 这里以向HKEY_CLASSES_ROOT里面添加项为例。

添加一个空的项到HKEY_CLASSES_ROOT中:<br>
```new RegAdd().addHKCR(项名称)```<br>
添加一个项到HKEY_CLASSES_ROOT中并指定其默认值的值:<br>
```new RegAdd().addHKCR(项名称,数据值)```<br>
添加一个项到HKEY_CLASSES_ROOT中并指定其子项的类型和值:<br>
```new RegAdd().addHKCR(项名称,其子项类型,子项值)```<br>
**这里类型对应如下:**<br>
```REG_SZ```:字符串值<br>
```REG_MULTI_SZ```:多字符串值<br>
```REG_EXPAND_SZ```:可扩展字符串值<br>
```REG_DWORD```:DWORD值<br>
```REG_QWORD```:QWORD值<br>
```REG_BINARY```:二进制值<br>
```REG_NONE```:无<br>
不分大小写。<br>

添加一个项到HKEY_CLASSES_ROOT中并指定其子项的名称、类型和值:<br>
```new RegAdd().addHKCR(项名称,子项类型,子项名称,子项值)```<br>

**例如给HKEY_CLASSES_ROOT里的AAM\shell里面加一个名为test的项:**<br>
```new RegAdd().addHKCR("AAM\\shell\\test");```<br>
**例如给HKEY_CLASSES_ROOT里的AAM\shell里面加一个名为test的项,并指定其子项类型为字符串值且值为2333:**<br>
```new RegAdd().addHKCR("AAM\\shell\\test","REG_SZ","2333");```<br>
#### (2)删除注册表项：
##### 这里以删除HKEY_CLASSES_ROOT里面的项为例。

删除HKEY_CLASSES_ROOT里面某一项及其所有子项:<br>
```new RegDelete().delHKCR(项名称)```<br>
删除HKEY_CLASSES_ROOT里面某项的某个子项:<br>
```new RegDelete().delHKCR(项名称,子项名称)```<br>
删除HKEY_CLASSES_ROOT里面某项的默认值:<br>
```new RegDelete().delHKCRve(项名称)```<br>

#### (3)查询注册表项(返回值String)：
##### 这里以查询HKEY_CLASSES_ROOT里面的项为例。

查询HKEY_CLASSES_ROOT下的某项及其所有子项的名称、类型和值:<br>
```new RegQuery().queryHKCR(项名称)```<br>
查询HKEY_CLASSES_ROOT下的某项的子项的信息:<br>
```new RegQuery().queryHKCR(项名称,子项名称)```<br>
查询HKEY_CLASSES_ROOT下的某项的默认子项信息:<br>
```new RegQuery().queryHKCRve(项名称)```<br>
判断HKEY_CLASSES_ROOT下的某一项是否存在:<br>
```new RegQuery().isHKCRexists(项名称)```<br>
判断HKEY_CLASSES_ROOT下的某一项的子项是否存在:<br>
```new RegQuery().isHKCRexists(项名称,子项名称)```<br>
判断HKEY_CLASSES_ROOT下的某一项的默认值是有内容（不为空）:<br>
```new RegQuery().isHKCRexistsve(项名称)```<br>

#### (4)导出注册表项为reg文件：
##### 这里以导出HKEY_CLASSES_ROOT里面的项为例。

导出HKEY_CLASSES_ROOT里面的某一项:<br>
```new RegExport().exportHKCR(项名称,导出文件路径)```<br>

**例如把HKEY_CLASSES_ROOT里的AAM\shell导出到E盘，保存为exp.reg:**<br>
```new RegExport().exportHKCR("AAM\\shell","E:\\exp.reg");```<br>

### 好的，以上添加、删除、查询和导出这四个操作都是以操作HKEY_CLASSES_ROOT这一基层类别键为例。如要操作其它键，把上面所有语句的方法名里面的键的简写（HKCR）换成其它键简写即可。
简写对应如下:<br>
```HKEY_CLASSES_ROOT```:HKCR<br>
```HKEY_CURRENT_USER```:HKCU<br>
```HKEY_LOCAL_MACHINE```:HKLM<br>
```HKEY_USERS```:HKU<br>
```HKEY_CURRENT_CONFIG```:HKCC<br>

**例如把HKEY_CURRENT_CONFIG里的Software\Fonts导出到E盘，保存为exp.reg:**
```new RegExport().exportHKCC("Software\\Fonts","E:\\exp.reg");```<br>

#### (5)从reg文件导入注册表项：

```new RegImport().importReg(reg文件路径)```<br>

