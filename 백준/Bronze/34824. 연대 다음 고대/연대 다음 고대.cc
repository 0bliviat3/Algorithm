#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	int n;
	std::cin >> n;

	std::string line;
	std::cin.ignore();

	int flag = 0;
	while (n--) {
		std::getline(std::cin, line);
		if (flag) {
			continue;
		}
		if (line == "yonsei") {
			flag = 1;
		}
		if (line == "korea") {
			flag = 2;
		}
	}
	
	if (flag == 1) {
		std::cout << "Yonsei Won!";
	} else {
		std::cout << "Yonsei Lost...";
	}


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}