//Created by Nathan Heckman
//Question 3 --- Array Testing
#include <iostream>

const int ARRAY_SIZE = 5000;
void arrayStatic();
void arrayStack();
void arrayDynamic();

int main() {
  //print time differences for array initialization
  arrayStatic();
  arrayStack();
  arrayDynamic();
}

void arrayStatic(){
  clock_t st; //INITIALIZE CLOCK
  st = clock(); //START CLOCK
  static int arr[ARRAY_SIZE]; //INITIALIZE STATIC ARRAY
  for(int i = 0; i < ARRAY_SIZE; i++){  //POPULATE ARRAY
    arr[i] = 0;
  }
  st = clock() - st;  //END CLOCK
  std::cout << "arrayStatic() Time: " << (float)st << std::endl; //REPORT TIME
}
void arrayStack(){
  clock_t st; //INITIALIZE CLOCK
  st = clock(); //START CLOCK
  int arr[ARRAY_SIZE]; //INITIALIZE STACK ARRAY
  for(int i = 0; i < ARRAY_SIZE; i++){  //POPULATE ARRAY
    arr[i] = 0;
  }
  st = clock() - st;  //END CLOCK
  std::cout << "arrayStack() Time: " << (float)st << std::endl; //REPORT TIME
}
void arrayDynamic(){
  clock_t st; //INITIALIZE CLOCK
  st = clock(); //START CLOCK
  int* arr = new int [ARRAY_SIZE]; //INITIALIZE DYNAMIC ARRAY
  for(int i = 0; i < ARRAY_SIZE; i++){  //POPULATE ARRAY
    arr[i] = 0;
  }
  st = clock() - st;  //END CLOCK
  std::cout << "arrayDynamic() Time: " << (float)st << std::endl; //REPORT TIME
}