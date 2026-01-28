#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

void solve() {

	int n;
	std::cin >> n;
	std::cin.ignore();

	std::string line1, line2;
	std::getline(std::cin, line1);
	std::getline(std::cin, line2);

	int size = line1.size();
	int sameCnt = 0;
	for (int i = 0; i < size; ++i) {
		if (line1[i] == line2[i]) {
			++sameCnt;
		}
	}
	if (sameCnt >= n) {
		std::cout << size - sameCnt + n;
	}  else {
		std::cout << size - n + sameCnt;
	}
	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}