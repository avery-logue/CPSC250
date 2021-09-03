with open("./src/LinkedListMethods.java") as source:
    for line in source:
        line=line.strip()
        if not (line.startswith('//') or line.startswith('/*') or line.startswith('*')):
            for token in line.split(" "):
                token=token.strip()
                if token.startswith("ArrayList") or token.startswith("java.util.ArrayList") or token.startswith("java.util.LinkedList") or token.startswith("java.util.*"):
                    with open('./arraylist_checker-result.txt','w') as output:
                        output.write('Tests run: 1,   Failures: 1')
                    exit(1)
                elif token.startswith("//") or token.startswith("/*") or token.startswith('*'):
                    continue
with open('./arraylist_checker-result.txt','w') as output:
    output.write('OK\n')
exit(0)
