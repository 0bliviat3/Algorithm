#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {

	std::string str;
	std::getline(std::cin, str);
	int size = str.size();
	int now = 1;
	int sum = 1;
	for (int i = 1; i < size ; ++i) {
		if (str[i] > str[i - 1]) {
			now++;
		} else {
			now = 1;
		}
		sum += now;
	}
	std::cout << sum;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}