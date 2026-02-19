#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int n, m;

	std::cin >> n >> m;

	int days[13] = { 0,31,28,31,30,31,30,31,31,30,31,30,31 };
	std::string dayOfWeek[7] = { "SUN","MON","TUE","WED","THU","FRI","SAT" };

	int totalDays = m;
	for (int i = 1; i < n; i++) {
		totalDays += days[i];
	}

	std::cout << dayOfWeek[totalDays % 7] << "\n";
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}