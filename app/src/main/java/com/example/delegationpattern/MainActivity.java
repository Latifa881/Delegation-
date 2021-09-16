package com.example.delegationpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwiftDeveloper switDev = new SwiftDeveloper();
        UXDesigner designer = new UXDesigner();
        KotlinDeveloper kotlinDev=new KotlinDeveloper();
        Employee james = new Employee(switDev,designer);
        Employee david = new Employee(kotlinDev,designer);
        james.writeCode();
        james.design();
        david.writeCode();
        david.design();
    }
}

// We use interfaces because we will use the same method but with different body

//creating WhoCanCode interface.
interface WhoCanCode {
    void writeCode();
}
//creating WhoCanDesign interface
interface WhoCanDesign {
    void design();
}
//here the employee can both write code and can design
class Employee implements WhoCanCode, WhoCanDesign {
    WhoCanCode developer;
    WhoCanDesign designer;
    public Employee(WhoCanCode developer, WhoCanDesign designer){
        this.developer = developer;
        this.designer = designer;
    }
    @Override
    public void writeCode() {
        developer.writeCode();
    }
    @Override
    public void design() {
        designer.design();
    }
}
//Here we only implements WhoCanCode and specify which language they can write
class SwiftDeveloper implements WhoCanCode {
    @Override
    public void writeCode() {
        System.out.println("I'm writing Swift Code");
    }
}
//Here we only implements WhoCanDesign and specify what the can design
class UXDesigner implements  WhoCanDesign {
    @Override
    public void design() {
        System.out.println("I'm designing UX");
    }}
//Here we only implements WhoCanCode and specify which language they can write
class KotlinDeveloper implements WhoCanCode
{
    @Override
    public void writeCode() {
        System.out.println("I'm writing Kotlin Code");
    }
}
