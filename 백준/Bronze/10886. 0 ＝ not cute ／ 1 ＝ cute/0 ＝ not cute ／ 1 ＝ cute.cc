#include <iostream>
#include <vector>
#include <sstream>
#include <string>

void solve() {
	int n;
	int val;
	int n_cnt = 0;
	int c_cnt = 0;
	std::cin >> n;

	while (n--) {
		std::cin >> val;
		if (val == 0) {
			n_cnt++;
		}
		else {
			c_cnt++;
		}
	}
	if (n_cnt > c_cnt) {
		std::cout << "Junhee is not cute!";
	}
	else {
		std::cout << "Junhee is cute!";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}