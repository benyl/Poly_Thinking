/* -*- Mode:C++; c-file-style:"gnu"; indent-tabs-mode:nil; -*- */
//-------------------------------------------------
// use a single array to implement three stacks
//-------------------------------------------------
#include <iostream>
#include <string>
using namespace std;

const int CAPACITY = 10 * 3;
int buffer[CAPACITY];
int stackSize[3] = {0, 0, 0};

// first stack start from 0
// middle stack start from 1/3 place (can be changed)
// end stack start from the end of array
int midStack = CAPACITY / 3;

int GetTopLocation(int stackId)
{
  int result = -1;
  switch(stackId)
  {
    case 0:
      result = stackSize[0] - 1;
      break;
    case 1:
      result = midStack + (stackSize[1] - 1);
      break;
    case 2:
      result = CAPACITY - 1 - (stackSize[2] - 1);
      break;
    default:
      throw string("unknown stack id.");
  }

  return result;
}

void Shift(bool forward) // shift middle stack
{
  if(stackSize[1] == 0) return; // do nothing

  if(forward)
  {
    for(int i=stackSize[1]; i>0; i--)
      buffer[midStack + i] = buffer[midStack + i - 1];
    midStack++;
  }
  else
  {
    for(int i=0; i<stackSize[1]; i++)
      buffer[midStack + i - 1] = buffer[midStack + i];
    midStack--;
  }
}

void Push(int stackId, int data)
{
  if(stackSize[0] + stackSize[1] + stackSize[2] == CAPACITY)
      throw string("stack already full.");

  switch(stackId)
  {
    case 0:
      if(stackSize[0] == midStack)
        Shift(true);// shift middle stack forward here 
      break;
    case 1:
    case 2:
      if(midStack + stackSize[1] + stackSize[2] == CAPACITY)
        Shift(false);// shift middle stack backward here
      break;
    default:
      throw string("unknown stack id.");
  }

  stackSize[stackId]++;
  buffer[GetTopLocation(stackId)] = data;
}

int Pop(int stackId)
{
  if(stackId < 0 || stackId > 2)
      throw string("unknown stack id.");
  if(stackSize[stackId] == 0)
      throw string("stack empty.");

  int result = buffer[GetTopLocation(stackId)];
  buffer[GetTopLocation(stackId)] = 0;
  stackSize[stackId]--;

  return result;
}

int Peak(int stackId)
{
  if(stackId < 0 || stackId > 2)
      throw string("unknown stack id.");
  if(stackSize[stackId] == 0)
      throw string("stack empty.");

  return buffer[GetTopLocation(stackId)];
}


int
main()
{
  try
  {
    Push(0, 0);
    Push(0, 1);
    Push(0, 2);
    Push(1, 100);
    Push(1, 200);
    for(int i=0; i<CAPACITY-5; i++)
      Push(2, i);

    for(int i = 0; i<3; i++)
      cout<<Peak(i)<< " ";
    cout << endl;

    for(int i = 0; i<3; i++)
      cout<<stackSize[i]<< " ";
    cout << midStack << endl;

    for(int i=0; i<CAPACITY; i++)
      {cout << buffer[i] << ((i%10!=9)?' ':'\n');}

    cout << "POP : ";
    for(int i=0; i<2; i++)
      cout<<Pop(0)<< " ";
    cout << endl;

    cout << "POP : ";
    for(int i=0; i<5; i++)
      cout<<Pop(2)<< " ";
    cout << endl;

    for(int i=0; i<7; i++)
      Push(1, i*100 + 300);

    for(int i = 0; i<3; i++)
      cout<<Peak(i)<< " ";
    cout << endl;

    for(int i = 0; i<3; i++)
      cout<<stackSize[i]<< " ";
    cout << midStack << endl;

    for(int i=0; i<CAPACITY; i++)
      {cout << buffer[i] << ((i%10!=9)?' ':'\n');}
  }
  catch (string &e)
  {
    cout << "catch exception: " << e << endl;
  }
  return 0;
}
