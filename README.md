# Essbase Outline Export Parser

Quick and dirty utility that can process an export XML file from the Essbase 
MaxL command, then dump the given dimension to the console in hierarchical form.

Given a file such as this:

```
<?xml version="1.0" encoding="UTF-8"?>
<application name="Sample" csversion="4.0" product="ESSBASE_PRODUCT" redeployType="tree" dimCount="10">
   <Dimension name="Year">
      <Generations>
         <GenLevel number="1" name="History" />
         <GenLevel number="2" name="Quarter" />
         <GenLevel number="3" name="Months" />
      </Generations>
      <Member name="Qtr1">
         <Member name="Jan" />
         <Member name="Feb" />
         <Member name="Mar" />
      </Member>
      <Member name="Qtr2">
         <Member name="Apr" />
         <Member name="May" />
         <Member name="Jun" />
      </Member>
      <Member name="Qtr3">
         <Member name="Jul" />
         <Member name="Aug" />
         <Member name="Sep" />
      </Member>
      <Member name="Qtr4">
         <Member name="Oct" />
         <Member name="Nov" />
         <Member name="Dec" />
      </Member>
   </Dimension>
   <Dimension name="Measures">
      <Member name="Profit">
         <Member name="Margin">
            <Member name="Sales" />
            <Member name="COGS" />
         </Member>
         <Member name="Total Expenses">
            <Member name="Marketing" />
            <Member name="Payroll" />
            <Member name="Misc" />
         </Member>
      </Member>
      <Member name="Inventory">
         <Member name="Opening Inventory" />
         <Member name="Additions" />
         <Member name="Ending Inventory" />
      </Member>
      <Member name="Ratios">
         <Member name="Margin %" />
         <Member name="Profit %" />
         <Member name="Profit per Ounce" />
      </Member>
   </Dimension>
   <Dimension name="Product">
      <AttributeDimension nameRef="Caffeinated" name="Caffeinated" />
      <AttributeDimension nameRef="Ounces" name="Ounces" />
      <AttributeDimension nameRef="Pkg Type" name="Pkg Type" />
      <AttributeDimension nameRef="Intro Date" name="Intro Date" />
      <Generations>
         <GenLevel number="2" name="Category" />
         <GenLevel number="3" name="Product SKU" />
      </Generations>
      <Levels>
         <GenLevel number="0" name="SKU" />
         <GenLevel number="1" name="Family" />
      </Levels>
      <Member name="100">
         <Member name="100-10" />
         <Member name="100-20" />
         <Member name="100-30" />
      </Member>
      <Member name="200">
         <Member name="200-10" />
         <Member name="200-20" />
         <Member name="200-30" />
         <Member name="200-40" />
      </Member>
      <Member name="300">
         <Member name="300-10" />
         <Member name="300-20" />
         <Member name="300-30" />
      </Member>
      <Member name="400">
         <Member name="400-10" />
         <Member name="400-20" />
         <Member name="400-30" />
      </Member>
      <Member name="Diet">
         <Member name="100-20" />
         <Member name="200-20" />
         <Member name="300-30" />
      </Member>
   </Dimension>
   <Dimension name="Market">
      <AttributeDimension nameRef="Population" name="Population" />
      <Generations>
         <GenLevel number="2" name="Region" />
         <GenLevel number="3" name="State" />
      </Generations>
      <Member name="East">
         <Member name="New York" />
         <Member name="Massachusetts" />
         <Member name="Florida" />
         <Member name="Connecticut" />
         <Member name="New Hampshire" />
      </Member>
      <Member name="West">
         <Member name="California" />
         <Member name="Oregon" />
         <Member name="Washington" />
         <Member name="Utah" />
         <Member name="Nevada" />
      </Member>
      <Member name="South">
         <Member name="Texas" />
         <Member name="Oklahoma" />
         <Member name="Louisiana" />
         <Member name="New Mexico" />
      </Member>
      <Member name="Central">
         <Member name="Illinois" />
         <Member name="Ohio" />
         <Member name="Wisconsin" />
         <Member name="Missouri" />
         <Member name="Iowa" />
         <Member name="Colorado" />
      </Member>
   </Dimension>
   <Dimension name="Scenario">
      <Member name="Actual" />
      <Member name="Budget" />
      <Member name="Variance" />
      <Member name="Variance %" />
   </Dimension>
   <Dimension name="Caffeinated">
      <Member name="True" />
      <Member name="False" />
   </Dimension>
   <Dimension name="Ounces">
      <Member name="32" />
      <Member name="20" />
      <Member name="16" />
      <Member name="12" />
   </Dimension>
   <Dimension name="Pkg Type">
      <Member name="Bottle" />
      <Member name="Can" />
   </Dimension>
   <Dimension name="Population">
      <Generations>
         <GenLevel number="2" name="Population group" />
         <GenLevel number="3" name="Population size" />
      </Generations>
      <Member name="Small">
         <Member name="3000000" />
         <Member name="6000000" />
      </Member>
      <Member name="Medium">
         <Member name="9000000" />
         <Member name="12000000" />
         <Member name="15000000" />
         <Member name="18000000" />
      </Member>
      <Member name="Large">
         <Member name="21000000" />
         <Member name="24000000" />
         <Member name="27000000" />
         <Member name="30000000" />
         <Member name="33000000" />
      </Member>
   </Dimension>
   <Dimension name="Intro Date">
      <Member name="03-25-1996" />
      <Member name="04-01-1996" />
      <Member name="09-27-1995" />
      <Member name="07-26-1996" />
      <Member name="12-10-1996" />
      <Member name="06-26-1996" />
      <Member name="10-01-1996" />
   </Dimension>
   <cube>
      <applicationSettings cubeType="BSO" />
      <databaseSettings>
         <bsoSettings dateFormat="yyyy-mm-dd" impliedSharedSetting="default On" locale="English_UnitedStates.Latin1@Binary" />
      </databaseSettings>
      <aliasTables>
         <Table name="Default" />
         <Table name="Long Names" />
         <DefaultTable name="Default" />
      </aliasTables>
      <dynamicTimeSeriesSettings>
         <H-T-D enabled="Y" generation="1" />
         <Q-T-D enabled="Y" generation="2" />
      </dynamicTimeSeriesSettings>
      <attributeSettings>
         <prefixSuffixValue>Prefix</prefixSuffixValue>
         <prefixSuffixFormat>Parent</prefixSuffixFormat>
      </attributeSettings>
      <attributeCalculationSettings>
         <BSOAttributeCalcs count="Count" min="Min" max="Max" avg="Avg" dimensionName="Attribute Calculations" sum="Sum" true="True" false="False" rangeName="Tops of Ranges" />
      </attributeCalculationSettings>
   </cube>
   <smartLists />
</application>
```

You can run the exporter:

```
java -jar essbase-outline-export-parser.jar input.xml Year
```

And it will print this output to the console (which you can pipe to a file or whatever):

```
Year
    Qtr1
        Jan
        Feb
        Mar
    Qtr2
        Apr
        May
        Jun
    Qtr3
        Jul
        Aug
        Sep
    Qtr4
        Oct
        Nov
        Dec
```