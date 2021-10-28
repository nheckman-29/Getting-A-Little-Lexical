#Created by Nathan Heckman
import re

#Example Java program shown below for demonstration purposes.
data = ''' 
public class add { //add two numbers
    public static void main(String[] args){
        int num1 = 5, num2 = 15, sum;
        sum = num1 + num2;
        System.out.println("Sum of these numbers: " + sum);
        
        float f = 10.4f;
        int i = 100;
    }
} 
'''

#Tokens derived from requirements detailed in assignment directions.
tokens = re.compile(r'''
  (\s+) |                      # whitespace
  (//)[^\n]* |                 # comments
  (\d*)\.\d+f? |               # float literals
  (\d+) |                      # integer literals
  ([][(){}<>=,;:*+-/]) |       # special
  ([A-Za-z_][A-Za-z0-9_]*) |   # identifiers
  "((?:[^"\n\\]|\\.)*)" |      # string literal
  (.)                          # error
''', re.DOTALL | re.VERBOSE)
#DOTALL allows for whitespace/newlines in token set to be ignored
#VERBOSE allows for greater token set readability

for match in re.finditer(tokens, data):     #for all matches in data...
    space, comment, _float, integer, \
    punct, identifier, stringlit, \
    badchar = match.groups()                #group together matches based on token set
    if space:
        continue                            #can be ignored since whitespace only used for readability in Java
    elif comment:
        print(match.group(), "--> COMMENT") #for remaining groups, print match and description
    elif integer:
        print(match.group(), "--> INTEGER LITERAL")
    elif _float:
        print(match.group(), "--> FLOAT LITERAL")
    elif punct:
        print(match.group(), "--> SPECIAL CHARACTER")
    elif identifier:
        print(match.group(), "--> IDENTIFIER")
    elif stringlit:
        print(match.group(), "--> STRING LITERAL")
    elif badchar:
        print("TOKEN NOT FOUND")    #would throw exception or error here