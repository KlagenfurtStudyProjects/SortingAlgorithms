import matplotlib.pyplot as plt


filename = '...\\measurement.txt'
with open(filename, 'r') as file:
    lines: list[str] = file.readlines()
    timeStr: str = lines[0].replace("\n", "")
    regSortStr: str = lines[1].replace("\n", "")
    medSortStr: str = lines[2].replace("\n", "")

time = []
timeValues: list[str] = timeStr.split(',')
for value in timeValues:
    if value != " " or value != ' ':
        time.append(value)

regSort = []
regSortValues: list[str] = regSortStr.split(',')
for value in regSortValues:
    if value != " " or value != ' ':
        regSort.append(int(value))

medSort = []
medSortValues: list[str] = medSortStr.split(',')
for value in medSortValues:
    if value != " " or value != ' ':
        medSort.append(int(value))

plt.figure(figsize=(8, 6))
plt.plot(time, regSort, label='Regular quick sort', color='blue', linestyle='-', marker='o')
plt.plot(time, medSort, label='Median quick sort', color='red', linestyle='--', marker='x')
plt.yscale('log')
plt.title('Reverse sorted array')
plt.xlabel('ArrayList size')
plt.ylabel('Time, ns')
plt.legend()
plt.grid(True)

plt.show()